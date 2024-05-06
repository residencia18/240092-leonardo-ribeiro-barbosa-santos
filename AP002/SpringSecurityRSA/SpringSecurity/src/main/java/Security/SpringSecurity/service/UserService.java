package Security.SpringSecurity.service;

import org.springframework.stereotype.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;


import Security.SpringSecurity.entity.User;
import Security.SpringSecurity.entity.PasswordResetToken;
import Security.SpringSecurity.repository.UserRepository;
import Security.SpringSecurity.repository.PasswordResetTokenRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    public void createPasswordResetToken(User user, String token) {
        PasswordResetToken resetToken = new PasswordResetToken(token, user);
        passwordResetTokenRepository.save(resetToken);
    }

    public void updatePassword(User user, String newPassword) {
        String encodedPassword = passwordEncoder.encode(newPassword);
        userRepository.updatePassword(user.getId(), encodedPassword);
    }
}
