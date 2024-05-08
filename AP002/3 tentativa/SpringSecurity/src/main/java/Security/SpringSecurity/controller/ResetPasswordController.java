package Security.SpringSecurity.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;

import Security.SpringSecurity.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

@RestController
@RequestMapping("/api")
public class ResetPasswordController {

    private final JwtDecoder jwtDecoder;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ResetPasswordController(JwtDecoder jwtDecoder, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.jwtDecoder = jwtDecoder;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
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

        } catch (Exception e) {
            return ResponseEntity.status(400).body("Token inválido");
        }

        // Procura o usuário com base no e-mail extraído do token JWT
        var userOptional = userRepository.findByEmail(email);
        if (userOptional.isEmpty()) {
            return ResponseEntity.status(404).body("Usuário não encontrado");
        }

        // Atualiza a senha do usuário no banco de dados
        var user = userOptional.get();
        var encodedPassword = passwordEncoder.encode(newPassword);
        userRepository.updatePassword(user.getId(), encodedPassword);

        return ResponseEntity.ok("Senha redefinida com sucesso");
    }




}

