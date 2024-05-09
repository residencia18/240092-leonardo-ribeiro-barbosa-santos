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

import Security.SpringSecurity.service.PasswordResetService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JwtProvider {
    private final JwtEncoder jwtEncoder;
    public static final Long EXPIRATION_TIME_IN_SECONDS = 3600L;
    private final PasswordResetService passwordResetService;

    
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
            JwtClaimsSet claims = JwtClaimsSet.builder()
                    .issuer("self")
                    .issuedAt(now)
                    .expiresAt(now.plusSeconds(3600))
                    .subject(user.getEmail())
                    .claim("purpose", "password_recovery")
                    .build();

            String token = this.jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
            passwordResetService.createPasswordResetToken(user, token); // Salvar token no banco de dados

            return token;
        }
    }

	


