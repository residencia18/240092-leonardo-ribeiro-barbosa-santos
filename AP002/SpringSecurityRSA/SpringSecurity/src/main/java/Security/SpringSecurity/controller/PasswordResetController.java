package Security.SpringSecurity.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Security.SpringSecurity.dto.ForgotPasswordRequest;
import Security.SpringSecurity.entity.User;
import Security.SpringSecurity.service.EmailService;
import Security.SpringSecurity.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class PasswordResetController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestBody ForgotPasswordRequest request) {
        String email = request.getEmail();
        User user = userService.findByEmail(email);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }

        // Gerar token seguro
        String token = UUID.randomUUID().toString();
        userService.createPasswordResetToken(user, token);

        // Enviar e-mail com link de redefinição
        String resetLink = "http://localhost:8080/api/auth/reset-password?token=" + token;
        emailService.sendPasswordResetEmail(user.getEmail(), resetLink);

        return ResponseEntity.ok("Reset link sent to email");
    }
}
