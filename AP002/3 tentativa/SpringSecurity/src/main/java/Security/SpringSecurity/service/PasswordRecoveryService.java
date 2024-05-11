package Security.SpringSecurity.service;

import org.springframework.stereotype.Service;

import Security.SpringSecurity.dto.PasswordRecoveryRequest;
import Security.SpringSecurity.entity.User;
import Security.SpringSecurity.exceptions.UserNotFoundException;
import Security.SpringSecurity.repository.UserRepository;
import Security.SpringSecurity.security.JwtProvider;

@Service
public class PasswordRecoveryService {

    private final UserRepository userRepository;
    private final EmailService emailService;
    private final JwtProvider jwtProvider;

    public PasswordRecoveryService(UserRepository userRepository, EmailService emailService, JwtProvider jwtProvider) {
        this.userRepository = userRepository;
        this.emailService = emailService;
        this.jwtProvider = jwtProvider;
    }

    public void requestPasswordRecovery(PasswordRecoveryRequest request) {
        String email = request.getEmail();
        var userOptional = userRepository.findByEmail(email);
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException("Usuário não encontrado com o e-mail especificado");
        }

        User user = userOptional.get();
        String token = jwtProvider.generateTokenForPasswordRecovery(user); 

        String resetLink = "http://localhost:8080/api/reset-password?token=" + token;
        emailService.sendSimpleEmail(
            "no-reply@example.com", 
            email, 
            "Recuperação de Senha", 
            "Clique no link para redefinir sua senha: " + resetLink
        );
    }
}

