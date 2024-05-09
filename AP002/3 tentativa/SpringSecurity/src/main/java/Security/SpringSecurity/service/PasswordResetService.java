package Security.SpringSecurity.service;

import java.time.Instant;

import org.springframework.stereotype.Service;

import Security.SpringSecurity.entity.PasswordResetToken;
import Security.SpringSecurity.entity.User;
import Security.SpringSecurity.repository.PasswordResetTokenRepository;

@Service
public class PasswordResetService {
    private final PasswordResetTokenRepository tokenRepository;

    public PasswordResetService(PasswordResetTokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    public PasswordResetToken createPasswordResetToken(User user, String token) {
        PasswordResetToken resetToken = new PasswordResetToken();
        resetToken.setToken(token);
        resetToken.setUser(user);
        resetToken.setExpirationDate(Instant.now().plusSeconds(3600)); // Expira em 1 hora
        return tokenRepository.save(resetToken);
    }
}
