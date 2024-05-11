package Security.SpringSecurity.service;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.oauth2.jwt.JwtDecoder;

import com.github.javafaker.Faker;

import Security.SpringSecurity.dto.PasswordRecoveryRequest;
import Security.SpringSecurity.entity.User;
import Security.SpringSecurity.exceptions.UserNotFoundException;
import Security.SpringSecurity.repository.UserRepository;
import Security.SpringSecurity.security.JwtProvider;
import Security.SpringSecurity.service.BlacklistService;
import Security.SpringSecurity.service.EmailService;
import Security.SpringSecurity.service.PasswordRecoveryService;
import Security.SpringSecurity.service.PasswordResetService;
import Security.SpringSecurity.service.ResetPasswordService;

import static org.mockito.Mockito.*;

import java.util.Optional;

@SpringBootTest
public class PasswordRecoveryServiceTest {
	
	@Mock
    private JwtDecoder jwtDecoder;
	
	@Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private UserRepository userRepository;
    
    @Mock
    private BlacklistService blacklistService;

    @Mock
    private JwtProvider jwtProvider;

    @Mock
    private EmailService emailService;
    
    @Mock
    private PasswordResetService passwordResetService;

    @InjectMocks
    private PasswordRecoveryService passwordRecoveryService;
    
    @InjectMocks
    private ResetPasswordService resetPasswordService;


    private final Faker faker = new Faker();

    @Test
    public void testRequestPasswordRecovery_UserFound() {
        // Criar uma requisição de recuperação de senha com um e-mail existente
        String email = faker.internet().emailAddress();
        PasswordRecoveryRequest request = new PasswordRecoveryRequest(email);

        // Mock do usuário encontrado no repositório
        User user = new User();
        user.setEmail(email);
        when(userRepository.findByEmail(email)).thenReturn(Optional.of(user));

        // Mock do token gerado pelo JwtProvider
        String token = faker.internet().password();
        when(jwtProvider.generateTokenForPasswordRecovery(user)).thenReturn(token);

        // Chamando o método a ser testado
        passwordRecoveryService.requestPasswordRecovery(request);

        // Verificar se o e-mail de recuperação foi enviado com os dados corretos
        String resetLink = "http://localhost:8080/api/reset-password?token=" + token;
        verify(emailService, times(1)).sendSimpleEmail(eq("no-reply@example.com"), eq(email), eq("Recuperação de Senha"), eq("Clique no link para redefinir sua senha: " + resetLink));
    }

    @Test
    public void testRequestPasswordRecovery_UserNotFound() {
        // Criar uma requisição de recuperação de senha com um e-mail não existente
        String email = faker.internet().emailAddress();
        PasswordRecoveryRequest request = new PasswordRecoveryRequest(email);

        // Mock do usuário não encontrado no repositório
        when(userRepository.findByEmail(email)).thenReturn(Optional.empty());

        // Chamando o método a ser testado e verificando se a exceção é lançada
        assertThrows(UserNotFoundException.class, () -> passwordRecoveryService.requestPasswordRecovery(request));

        // Verificar se o emailService.sendSimpleEmail não foi chamado
        verify(emailService, never()).sendSimpleEmail(any(), any(), any(), any());
    }
   
}




