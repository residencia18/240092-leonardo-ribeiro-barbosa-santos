package Security.SpringSecurity.Controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import Security.SpringSecurity.controller.ResetPasswordController;
import Security.SpringSecurity.dto.ResetPasswordRequest;
import Security.SpringSecurity.dto.ResetPasswordResponse;
import Security.SpringSecurity.service.ResetPasswordService;
import com.github.javafaker.Faker;

public class ResetPasswordControllerTest {

    private ResetPasswordController resetPasswordController;

    @Mock
    private ResetPasswordService resetPasswordService;

    private Faker faker;

    @BeforeEach
    public void setUp() {
        resetPasswordController = new ResetPasswordController(resetPasswordService);
        faker = new Faker();
    }

    @Test
    public void testResetPassword_Success() {
        String token = faker.internet().uuid();
        String newPassword = faker.internet().password();

        ResetPasswordRequest requestDTO = new ResetPasswordRequest(token, newPassword);

        ResponseEntity<ResetPasswordResponse> responseEntity = resetPasswordController.resetPassword(requestDTO);

        verify(resetPasswordService, times(1)).resetPassword(requestDTO);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals("Senha redefinida com sucesso", responseEntity.getBody().getMessage());
    }
}


