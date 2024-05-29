package Security.SpringSecurity.service;

import java.time.Instant;
import java.util.Optional;

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
        // Verifica se o token já existe na base de dados
        Optional<PasswordResetToken> existingToken = tokenRepository.findByToken(token);
        if (existingToken.isPresent()) {
            return existingToken.get(); // Retorna o token existente
        }

        // Cria um novo token de redefinição de senha
        PasswordResetToken resetToken = new PasswordResetToken();
        resetToken.setToken(token);
        resetToken.setUser(user);
        resetToken.setExpirationDate(Instant.now().plusSeconds(3600)); // Expira em 1 hora
        return tokenRepository.save(resetToken);
    }

}
