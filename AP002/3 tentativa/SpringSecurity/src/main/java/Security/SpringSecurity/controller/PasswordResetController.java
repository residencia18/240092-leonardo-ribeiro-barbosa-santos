package Security.SpringSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import Security.SpringSecurity.service.TokenService;
import Security.SpringSecurity.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class PasswordResetController {

    private final TokenService tokenService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public PasswordResetController(TokenService tokenService, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.tokenService = tokenService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestParam String token, @RequestParam String newPassword) {
        var email = tokenService.getEmailByToken(token);
        
        if (email == null) {
            return ResponseEntity.status(400).body("Token inválido ou expirado");
        }

        var userOptional = userRepository.findByEmail(email);
        if (userOptional.isEmpty()) {
            return ResponseEntity.status(404).body("Usuário não encontrado");
        }

        var user = userOptional.get();
        var encodedPassword = passwordEncoder.encode(newPassword);

        // Atualizar a senha no banco de dados
        userRepository.updatePassword(user.getId(), encodedPassword);

        // Invalidar o token após redefinir a senha
        tokenService.invalidateToken(token);

        return ResponseEntity.ok("Senha redefinida com sucesso");
    }
}
