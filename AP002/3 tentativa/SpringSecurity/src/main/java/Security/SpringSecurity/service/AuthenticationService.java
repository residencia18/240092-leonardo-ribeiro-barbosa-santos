package Security.SpringSecurity.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import Security.SpringSecurity.dto.LoginRequest;
import Security.SpringSecurity.dto.LoginResponse;
import Security.SpringSecurity.dto.RegisterRequest;
import Security.SpringSecurity.entity.User;
import Security.SpringSecurity.mapper.UserMapper;
import Security.SpringSecurity.repository.UserRepository;
import Security.SpringSecurity.security.JwtProvider;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    private final UserMapper userMapper;

    public void register(RegisterRequest registerRequest) {
        // Usando o UserMapper para criar o objeto User
        User user = userMapper.fromRegisterRequest(registerRequest);
        // Codificando a senha antes de salvar
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // Salvar o usuário usando o método save do JpaRepository
        userRepository.save(user);
    }

    public LoginResponse login(LoginRequest loginRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.username(),
                loginRequest.password()));
        String token = jwtProvider.generateToken(authenticate);
        return new LoginResponse(token);
    }
    
    
}