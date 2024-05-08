package Security.SpringSecurity.security;

import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JwtProvider {
    private final JwtEncoder jwtEncoder;
    public static final Long EXPIRATION_TIME_IN_SECONDS = 3600L;

    
    public String generateToken(Authentication authentication) {
        User principal = (User) authentication.getPrincipal();
        var now = Instant.now();
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(EXPIRATION_TIME_IN_SECONDS))
                .subject(principal.getUsername())
                .claim("scope", "ROLE_USER")
                .build();

        return this.jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

    public String generateTokenForPasswordRecovery(Security.SpringSecurity.entity.User user) {
        var now = Instant.now();
        var expiration = now.plusSeconds(EXPIRATION_TIME_IN_SECONDS); // Token expira em 1 hora
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(expiration)
                .subject(user.getEmail()) // Verifique se este campo é o mesmo que você usa para buscar no banco de dados // O e-mail ou nome de usuário
                .claim("purpose", "password_recovery") // Indicação do propósito do token
                .build();

        String token = this.jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
        Logger logger = LoggerFactory.getLogger(JwtProvider.class);
        logger.info("Generated token: {}", token); // Loga o token gerado
        return token;
    }

	


}