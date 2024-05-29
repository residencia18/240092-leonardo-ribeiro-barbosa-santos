package Security.SpringSecurity.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.stereotype.Service;

import Security.SpringSecurity.dto.ResetPasswordRequest;
import Security.SpringSecurity.entity.User;
import Security.SpringSecurity.exceptions.InvalidTokenException;
import Security.SpringSecurity.exceptions.TokenExpiredException;
import Security.SpringSecurity.exceptions.UserNotFoundException;
import Security.SpringSecurity.repository.UserRepository;

@Service
public class ResetPasswordService {

    private final JwtDecoder jwtDecoder;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final BlacklistService blacklistService;
    private final PasswordResetService passwordResetService;

    @Autowired
    public ResetPasswordService(JwtDecoder jwtDecoder, UserRepository userRepository, PasswordEncoder passwordEncoder, BlacklistService blacklistService, PasswordResetService passwordResetService) {
        this.jwtDecoder = jwtDecoder;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.blacklistService = blacklistService;
        this.passwordResetService = passwordResetService;
    }

    public void resetPassword(ResetPasswordRequest requestDTO) {
        String email;
        try {
            Jwt jwt = jwtDecoder.decode(requestDTO.getToken());
            email = jwt.getSubject();

            Instant expiresAt = jwt.getExpiresAt();
            if (expiresAt == null || expiresAt.isBefore(Instant.now())) {
                throw new TokenExpiredException("Token expirado");
            }

            if (blacklistService.isTokenBlacklisted(requestDTO.getToken())) {
                throw new InvalidTokenException("Token inválido");
            }

        } catch (JwtException | InvalidTokenException | TokenExpiredException e) {
            throw new InvalidTokenException("Token inválido");
        }

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado"));

        String encodedPassword = passwordEncoder.encode(requestDTO.getNewPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);

        blacklistService.blacklistToken(requestDTO.getToken());

        // Criar token de redefinição de senha
        passwordResetService.createPasswordResetToken(user, requestDTO.getToken());
    }
}
