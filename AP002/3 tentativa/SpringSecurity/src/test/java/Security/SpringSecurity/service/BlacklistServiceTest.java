package Security.SpringSecurity.service;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.javafaker.Faker;

import Security.SpringSecurity.entity.BlacklistedToken;
import Security.SpringSecurity.repository.BlacklistRepository;

@SpringBootTest
class BlacklistServiceTest {

	@Mock
    private BlacklistRepository blacklistRepository;

    @InjectMocks
    private BlacklistService blacklistService;

    private final Faker faker = new Faker();

    @Test
    public void testBlacklistToken() {
        String token = faker.internet().uuid();

        BlacklistedToken blacklistedToken = new BlacklistedToken();
        blacklistedToken.setToken(token);

        Mockito.when(blacklistRepository.save(Mockito.any())).thenReturn(blacklistedToken);

        blacklistService.blacklistToken(token);

        Mockito.verify(blacklistRepository).save(Mockito.any());
    }
    
    @Test
    public void testIsTokenBlacklisted() {
        String token = faker.internet().uuid();

        Mockito.when(blacklistRepository.existsByToken(token)).thenReturn(true);

        assertTrue(blacklistService.isTokenBlacklisted(token));

        Mockito.when(blacklistRepository.existsByToken(token)).thenReturn(false);

        assertFalse(blacklistService.isTokenBlacklisted(token));
    }
}

