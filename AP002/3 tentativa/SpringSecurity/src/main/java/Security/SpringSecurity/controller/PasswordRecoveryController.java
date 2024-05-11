package Security.SpringSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Security.SpringSecurity.dto.PasswordRecoveryRequest;
import Security.SpringSecurity.service.PasswordRecoveryService;

@RestController
@RequestMapping("/api")
public class PasswordRecoveryController {

    private final PasswordRecoveryService passwordRecoveryService;

    @Autowired
    public PasswordRecoveryController(PasswordRecoveryService passwordRecoveryService) {
        this.passwordRecoveryService = passwordRecoveryService;
    }

    @PostMapping("/password-recovery")
    public ResponseEntity<String> requestPasswordRecovery(@RequestBody PasswordRecoveryRequest request) {
        passwordRecoveryService.requestPasswordRecovery(request);
        return ResponseEntity.ok("Um link de recuperação de senha foi enviado para seu e-mail.");
    }
}

