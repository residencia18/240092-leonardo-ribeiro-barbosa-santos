package Security.SpringSecurity.service;

import java.security.SecureRandom;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Security.SpringSecurity.entity.PasswordResetToken;
import Security.SpringSecurity.entity.User;
import Security.SpringSecurity.repository.PasswordResetTokenRepository;

@Service
public class PasswordResetTokenService {

    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;

    @Autowired
    private SecureRandom secureRandom;

    public PasswordResetToken createResetToken(User user) {
        String token = generateUniqueToken();
        PasswordResetToken resetToken = new PasswordResetToken(token, user);
        passwordResetTokenRepository.save(resetToken);
        return resetToken;
    }

    private String generateUniqueToken() {
        byte[] randomBytes = new byte[32];
        secureRandom.nextBytes(randomBytes);
        return Base64.getEncoder().encodeToString(randomBytes);
    }

    public PasswordResetToken findByToken(String token) {
        return passwordResetTokenRepository.findByToken(token);
    }
}


