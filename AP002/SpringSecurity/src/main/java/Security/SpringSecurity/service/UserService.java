package Security.SpringSecurity.service;

import java.time.LocalDateTime;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import Security.SpringSecurity.entity.User;
import Security.SpringSecurity.entity.PasswordResetToken;
import Security.SpringSecurity.repository.UserRepository;
import Security.SpringSecurity.repository.PasswordResetTokenRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository; // Injeção do repositório de usuários
    private  PasswordEncoder passwordEncoder;
    
    @Autowired
    private PasswordResetTokenRepository passwordTokenRepository; // Injeção do repositório de tokens

    public User findUserByEmail(String email) {
        // Retornar o usuário ou null se não for encontrado
        return userRepository.findByEmail(email).orElse(null);
    }

    public void createPasswordResetTokenForUser(User user, String token) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        
        PasswordResetToken myToken = new PasswordResetToken(token, user);
        passwordTokenRepository.save(myToken); // Salvar o token
    }
    
    public String validatePasswordResetToken(String token) {
        final PasswordResetToken passToken = passwordTokenRepository.findByToken(token);

        return !isTokenFound(passToken) ? "invalidToken"
                : isTokenExpired(passToken) ? "expired"
                : null;
    }
    
    private boolean isTokenFound(PasswordResetToken passToken) {
        return passToken != null;
    }

    private boolean isTokenExpired(PasswordResetToken passToken) {
        final Calendar cal = Calendar.getInstance();
        final LocalDateTime now = LocalDateTime.now();
        return passToken.getExpiryDate().isBefore(now);
    }
    
   
}
