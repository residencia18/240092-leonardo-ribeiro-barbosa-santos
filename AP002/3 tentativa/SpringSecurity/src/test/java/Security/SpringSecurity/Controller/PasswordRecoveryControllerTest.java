package Security.SpringSecurity.Controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import Security.SpringSecurity.controller.PasswordRecoveryController;
import Security.SpringSecurity.dto.PasswordRecoveryRequest;
import Security.SpringSecurity.service.PasswordRecoveryService;
import com.github.javafaker.Faker;

public class PasswordRecoveryControllerTest {

    private PasswordRecoveryController passwordRecoveryController;

    @Mock
    private PasswordRecoveryService passwordRecoveryService;

    private Faker faker;

    @BeforeEach
    public void setUp() {
        passwordRecoveryController = new PasswordRecoveryController(passwordRecoveryService);
        faker = new Faker();
    }

    @Test
    public void testRequestPasswordRecovery_Success() {
        String email = faker.internet().emailAddress();

        PasswordRecoveryRequest request = new PasswordRecoveryRequest();
        request.setEmail(email);

        ResponseEntity<String> responseEntity = passwordRecoveryController.requestPasswordRecovery(request);

        verify(passwordRecoveryService, times(1)).requestPasswordRecovery(request);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals("Um link de recuperação de senha foi enviado para seu e-mail.", responseEntity.getBody());
    }
}
