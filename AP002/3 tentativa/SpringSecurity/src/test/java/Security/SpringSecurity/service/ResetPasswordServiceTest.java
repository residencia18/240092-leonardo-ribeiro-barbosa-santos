package Security.SpringSecurity.service;

import com.github.javafaker.Faker;

import Security.SpringSecurity.dto.ResetPasswordRequest;
import Security.SpringSecurity.entity.User;
import Security.SpringSecurity.exceptions.InvalidTokenException;
import Security.SpringSecurity.exceptions.TokenExpiredException;
import Security.SpringSecurity.exceptions.UserNotFoundException;
import Security.SpringSecurity.repository.UserRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;

import java.time.Instant;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ResetPasswordServiceTest {

    @Mock
    private JwtDecoder jwtDecoder;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private BlacklistService blacklistService;

    @Mock
    private PasswordResetService passwordResetService;

    @InjectMocks
    private ResetPasswordService resetPasswordService;

    private final Faker faker = new Faker();

    @Test
    public void testResetPassword_TokenExpired() {
        // Configure a Jwt with an expired expiration time
        Instant expiredInstant = Instant.now().minusSeconds(3600); // Expired 1 hour ago
        Jwt jwt = mock(Jwt.class);
        when(jwt.getExpiresAt()).thenReturn(expiredInstant);
        when(jwtDecoder.decode(anyString())).thenReturn(jwt);

        // Mock the behavior of blacklistService
        when(blacklistService.isTokenBlacklisted(anyString())).thenReturn(false);

        // Assert that TokenExpiredException is thrown
        assertThrows(TokenExpiredException.class, () -> {
            // Generate random token and password with Faker
            ResetPasswordRequest request = new ResetPasswordRequest(faker.internet().password(), faker.internet().password());
            
            // Call resetPassword method with the expired token
            resetPasswordService.resetPassword(request);
        });
    }



    @Test
    public void testResetPassword_InvalidToken() {
        // Simulate an invalid token
        when(jwtDecoder.decode(anyString())).thenThrow(new JwtException("Invalid token"));

        // Call the method and verify if InvalidTokenException is thrown
        assertThrows(InvalidTokenException.class, ()  -> resetPasswordService.resetPassword(new ResetPasswordRequest(faker.internet().password(), faker.internet().password())));
    }

    @Test
    public void testResetPassword_UserNotFound() {
        // Arrange
        String token = "validToken";
        String newPassword = faker.internet().password();
        String nonexistentEmail = faker.internet().emailAddress();

        Jwt jwt = mock(Jwt.class);
        when(jwt.getSubject()).thenReturn(nonexistentEmail);
        when(jwt.getExpiresAt()).thenReturn(Instant.now().plusSeconds(3600));

        ResetPasswordRequest request = new ResetPasswordRequest(token, newPassword);

        // Mock do comportamento das dependências
        when(jwtDecoder.decode(token)).thenReturn(jwt);
        when(userRepository.findByEmail(nonexistentEmail)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(UserNotFoundException.class, () -> resetPasswordService.resetPassword(request));
        verify(passwordResetService, never()).createPasswordResetToken(any(), any());
    }


    @Test
    public void testResetPassword_Success() {
        // Arrange
        String token = faker.internet().password();
        String newPassword = faker.internet().password();

        Jwt jwt = mock(Jwt.class);
        when(jwt.getSubject()).thenReturn("user@example.com");
        when(jwt.getExpiresAt()).thenReturn(Instant.now().plusSeconds(3600));

        User user = new User();
        user.setEmail("user@example.com");

        ResetPasswordRequest request = new ResetPasswordRequest(token, newPassword);

        // Mock do comportamento das dependências
        when(jwtDecoder.decode(token)).thenReturn(jwt);
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.of(user));
        when(passwordEncoder.encode(newPassword)).thenReturn("encodedPassword");
        when(blacklistService.isTokenBlacklisted(token)).thenReturn(false);

        // Act
        resetPasswordService.resetPassword(request);

        // Assert
        verify(userRepository, times(1)).save(user);
        verify(blacklistService, times(1)).blacklistToken(token);
        verify(passwordResetService, times(1)).createPasswordResetToken(any(), eq(token));
    }

}

