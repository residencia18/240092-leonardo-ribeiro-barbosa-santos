package Security.SpringSecurity.controller;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

import Security.SpringSecurity.entity.User; // Classe que representa um usuário
import Security.SpringSecurity.service.EmailService;
import Security.SpringSecurity.security.JwtProvider;
import Security.SpringSecurity.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class PasswordRecoveryController {

    private final EmailService emailService;
    private final JwtProvider jwtProvider;
    private final UserRepository userRepository;

    @Autowired
    public PasswordRecoveryController(EmailService emailService, JwtProvider jwtProvider, UserRepository userRepository) {
        this.emailService = emailService;
        this.jwtProvider = jwtProvider;
        this.userRepository = userRepository;
    }

    @PostMapping("/password-recovery")
    public ResponseEntity<String> requestPasswordRecovery(@RequestParam String email) {
        // Verifica se o usuário existe pelo e-mail
        var userOptional = userRepository.findByEmail(email);
        if (userOptional.isEmpty()) {
            return ResponseEntity.status(404).body("Usuário não encontrado com o e-mail especificado");
        }

        // Obtém o usuário
        User user = userOptional.get();

        // Gere o token JWT para recuperação de senha usando o objeto User
        String token = jwtProvider.generateTokenForPasswordRecovery(user); 

        // Enviar e-mail com o link para redefinição de senha
        String resetLink = "http://localhost:8080/api/reset-password?token=" + token;
        emailService.sendSimpleEmail(
            "no-reply@example.com", 
            email, 
            "Recuperação de Senha", 
            "Clique no link para redefinir sua senha: " + resetLink
        );

        return ResponseEntity.ok("Um link de recuperação de senha foi enviado para seu e-mail.");
    }
}
