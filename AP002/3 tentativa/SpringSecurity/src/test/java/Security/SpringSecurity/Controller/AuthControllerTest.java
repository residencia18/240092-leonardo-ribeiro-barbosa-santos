package Security.SpringSecurity.Controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import Security.SpringSecurity.controller.AuthController;
import Security.SpringSecurity.dto.LoginRequest;
import Security.SpringSecurity.dto.LoginResponse;
import Security.SpringSecurity.dto.RegisterRequest;
import Security.SpringSecurity.dto.RegisterResponse;
import Security.SpringSecurity.service.AuthenticationService;
import com.github.javafaker.Faker;

public class AuthControllerTest {

    private AuthController authController;

    @Mock
    private AuthenticationService authenticationService;

    private Faker faker;

    @BeforeEach
    public void setUp() {
        authController = new AuthController(authenticationService);
        faker = new Faker();
    }

    @Test
    public void testRegister_Success() {
        // Gerando dados fictícios para o registro
        String username = faker.name().username();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();

        // Criando uma solicitação de registro com dados fictícios
        RegisterRequest registerRequest = new RegisterRequest(username, email, password);

        // Chamando o método register no controlador
        RegisterResponse registerResponse = authController.register(registerRequest);

        verify(authenticationService, times(1)).register(registerRequest);

        assertNotNull(registerResponse);
        assertEquals("User registered successfully", registerResponse.message());
    }

    @Test
    public void testLogin_Success() {
        // Gerando dados fictícios para o login
        String username = faker.name().username();
        String password = faker.internet().password();

        // Criando uma solicitação de login com dados fictícios
        LoginRequest loginRequest = new LoginRequest(username, password);

        // Criando uma resposta de login fictícia
        LoginResponse loginResponse = new LoginResponse("fake_token");

        // Mockando o serviço de autenticação para retornar a resposta fictícia
        when(authenticationService.login(loginRequest)).thenReturn(loginResponse);

        // Chamando o método login no controlador
        LoginResponse response = authController.login(loginRequest);

        // Verificando se o serviço de autenticação foi chamado corretamente com os dados fictícios
        verify(authenticationService, times(1)).login(loginRequest);

        // Verificando se a resposta do controlador é igual à resposta fictícia
        assertEquals(loginResponse, response);
    }
}

