package Security.SpringSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Security.SpringSecurity.dto.ResetPasswordRequest;
import Security.SpringSecurity.dto.ResetPasswordResponse;
import Security.SpringSecurity.service.ResetPasswordService;

@RestController
@RequestMapping("/api")
public class ResetPasswordController {

    private final ResetPasswordService resetPasswordService;

    @Autowired
    public ResetPasswordController(ResetPasswordService resetPasswordService) {
        this.resetPasswordService = resetPasswordService;
    }

    @PostMapping("/reset-password")
    public ResponseEntity<ResetPasswordResponse> resetPassword(@RequestBody ResetPasswordRequest requestDTO) {
        resetPasswordService.resetPassword(requestDTO);
        return ResponseEntity.ok(new ResetPasswordResponse("Senha redefinida com sucesso"));
    }
}
