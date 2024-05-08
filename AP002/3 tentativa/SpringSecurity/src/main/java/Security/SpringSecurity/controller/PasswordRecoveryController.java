package Security.SpringSecurity.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import Security.SpringSecurity.service.EmailService;
import Security.SpringSecurity.service.TokenService;
import Security.SpringSecurity.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class PasswordRecoveryController {

    private final EmailService emailService;
    private final TokenService tokenService;
    private final UserRepository userRepository;

    @Autowired
    public PasswordRecoveryController(EmailService emailService, TokenService tokenService, UserRepository userRepository) {
        this.emailService = emailService;
        this.tokenService = tokenService;
        this.userRepository = userRepository;
    }


    @PostMapping("/password-recovery")
    public ResponseEntity<String> requestPasswordRecovery(@RequestParam(value = "email",required = true) String email) {
        Logger logger = LoggerFactory.getLogger(getClass());
        logger.info("E-mail recebido: {}", email);
        var userOptional = userRepository.findByEmail(email);
        if (userOptional.isEmpty()) {
            return ResponseEntity.status(404).body("Usuário não encontrado com o e-mail especificado");
        }

        var token = tokenService.createToken(email);
        var resetLink = "http://localhost:8080/api/reset-password?token=" + token;

        emailService.sendSimpleEmail("no-reply@example.com", email, "Recuperação de Senha", 
            "Clique no link para redefinir sua senha: " + resetLink);

        return ResponseEntity.ok("Um link de recuperação de senha foi enviado para seu e-mail.");
    }
}
