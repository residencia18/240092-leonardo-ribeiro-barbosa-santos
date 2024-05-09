package Security.SpringSecurity.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;

import Security.SpringSecurity.repository.UserRepository;
import Security.SpringSecurity.service.BlacklistService;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.Instant;

@RestController
@RequestMapping("/api")
public class ResetPasswordController {

    private final JwtDecoder jwtDecoder;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final BlacklistService blacklistService;

    @Autowired
    public ResetPasswordController(
        JwtDecoder jwtDecoder,
        UserRepository userRepository,
        PasswordEncoder passwordEncoder,
        BlacklistService blacklistService // Certifique-se de injetar o BlacklistService no construtor
    ) {
        this.jwtDecoder = jwtDecoder;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.blacklistService = blacklistService; // Inicialize o campo final no construtor
    }

    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(
        @RequestParam String token,
        @RequestParam String newPassword
    ) {
        String email;
        try {
            Jwt jwt = jwtDecoder.decode(token);

            email = jwt.getSubject(); // Extrai o 'subject' do token JWT

            // Verifica se a data de expiração está definida e se o token está expirado
            Instant expiresAt = jwt.getExpiresAt();
            if (expiresAt == null || expiresAt.isBefore(Instant.now())) {
                return ResponseEntity.status(400).body("Token expirado");
            }

            // Verificar se o token já está na lista negra
            if (blacklistService.isTokenBlacklisted(token)) {
                return ResponseEntity.status(400).body("Token inválido");
            }

        } catch (Exception e) {
            return ResponseEntity.status(400).body("Token inválido");
        }

        var userOptional = userRepository.findByEmail(email);
        if (userOptional.isEmpty()) {
            return ResponseEntity.status(404).body("Usuário não encontrado");
        }

        var user = userOptional.get();
        var encodedPassword = passwordEncoder.encode(newPassword);
        user.setPassword(encodedPassword);
        userRepository.save(user);

        // Colocar o token na lista negra após a redefinição da senha
        blacklistService.blacklistToken(token);

        return ResponseEntity.ok("Senha redefinida com sucesso");
    }

}
