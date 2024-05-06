package Security.SpringSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

 

    	@Autowired
        private final UserRepository userRepository;
        private final PasswordEncoder passwordEncoder;
        private final AuthenticationManager authenticationManager;
        private final JwtProvider jwtProvider;
        private final UserMapper userMapper;

        @Transactional // Transação normal porque estamos modificando dados (criando um novo usuário)
        public void register(RegisterRequest registerRequest) {
            User user = userMapper.fromRegisterRequest(registerRequest);
            user.setPassword(passwordEncoder.encode(registerRequest.password())); // Codifica a senha
            userRepository.save(user); // Salva usando JPA
        }

        @Transactional(readOnly = true) // Somente leitura porque estamos apenas autenticando
        public LoginResponse login(LoginRequest loginRequest) {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password())
            );
            String token = jwtProvider.generateToken(authentication); // Gerar token JWT
            return new LoginResponse(token); // Retorna a resposta do token
        }
    }
