package Security.SpringSecurity.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.Instant;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import Security.SpringSecurity.entity.PasswordResetToken;
import Security.SpringSecurity.entity.User;
import Security.SpringSecurity.repository.PasswordResetTokenRepository;
import com.github.javafaker.Faker;

public class PasswordResetServiceTest {

    @Mock
    private PasswordResetTokenRepository tokenRepository;

    private PasswordResetService passwordResetService;

    private Faker faker;

    @BeforeEach
    public void setUp() {
        passwordResetService = new PasswordResetService(tokenRepository);
        faker = new Faker();
    }

    @Test
    public void testCreatePasswordResetToken_NewToken() {
        User user = new User();
        
        String token = faker.internet().uuid();
        
        when(tokenRepository.findByToken(token)).thenReturn(Optional.empty());

        PasswordResetToken resetToken = passwordResetService.createPasswordResetToken(user, token);

        assertNotNull(resetToken);
        assertEquals(token, resetToken.getToken());
        assertEquals(user, resetToken.getUser());
        assertNotNull(resetToken.getExpirationDate());
        
        verify(tokenRepository, times(1)).findByToken(token);
        verify(tokenRepository, times(1)).save(resetToken);
    }

    @Test
    public void testCreatePasswordResetToken_ExistingToken() {
        User user = new User();
        
        String token = faker.internet().uuid();

        PasswordResetToken existingToken = new PasswordResetToken();
        existingToken.setToken(token);
        existingToken.setUser(user);
        existingToken.setExpirationDate(Instant.now().plusSeconds(3600));

        when(tokenRepository.findByToken(token)).thenReturn(Optional.of(existingToken));

        PasswordResetToken resetToken = passwordResetService.createPasswordResetToken(user, token);

        assertNotNull(resetToken);
        assertEquals(existingToken, resetToken);
        
        verify(tokenRepository, times(1)).findByToken(token);
        verify(tokenRepository, never()).save(any(PasswordResetToken.class));
    }
}


