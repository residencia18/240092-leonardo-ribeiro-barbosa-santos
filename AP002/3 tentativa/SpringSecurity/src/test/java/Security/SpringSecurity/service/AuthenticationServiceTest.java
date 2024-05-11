package Security.SpringSecurity.service;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import Security.SpringSecurity.dto.LoginRequest;
import Security.SpringSecurity.dto.LoginResponse;
import Security.SpringSecurity.dto.RegisterRequest;
import Security.SpringSecurity.entity.User;
import Security.SpringSecurity.mapper.UserMapper;
import Security.SpringSecurity.repository.UserRepository;
import Security.SpringSecurity.security.JwtProvider;

import static org.mockito.Mockito.*;

public class AuthenticationServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private JwtProvider jwtProvider;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private AuthenticationService authenticationService;

    private Faker faker;

    @BeforeEach
    public void setUp() {
        faker = new Faker();
    }

    @Test
    public void testRegister() {
        // Given
        RegisterRequest registerRequest = new RegisterRequest(faker.name().username(), faker.internet().password(), faker.internet().emailAddress());
        User user = new User();
        user.setUsername(registerRequest.username());
        user.setEmail(registerRequest.email());
        user.setPassword(registerRequest.password());
        when(userMapper.fromRegisterRequest(registerRequest)).thenReturn(user);

        // When
        authenticationService.register(registerRequest);

        // Then
        verify(passwordEncoder).encode(registerRequest.password());
        verify(userRepository).save(user);
    }

    @Test
    public void testLogin() {
        // Given
        String username = faker.name().username();
        String password = faker.internet().password();
        LoginRequest loginRequest = new LoginRequest(username, password);
        Authentication authentication = mock(Authentication.class);
        UserDetails userDetails = mock(UserDetails.class);
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class))).thenReturn(authentication);
        when(authentication.getPrincipal()).thenReturn(userDetails);
        when(jwtProvider.generateToken(authentication)).thenReturn("testToken");

        // When
        LoginResponse loginResponse = authenticationService.login(loginRequest);

        // Then
        verify(authenticationManager).authenticate(any(UsernamePasswordAuthenticationToken.class));
        verify(jwtProvider).generateToken(authentication);
        // You might want to assert the loginResponse here if needed
    }
}
