package Security.SpringSecurity.mapper;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import Security.SpringSecurity.dto.RegisterRequest;
import Security.SpringSecurity.entity.Role;
import Security.SpringSecurity.entity.User;

@Service
public class UserMapper {
	private final PasswordEncoder passwordEncoder;

    public UserMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public User fromRegisterRequest(RegisterRequest registerRequest) {
        // Cria o conjunto de papéis para o novo usuário
        Set<Role> roles = new HashSet<>();

        // Adiciona o papel de usuário como padrão
        Role defaultRole = new Role();
        defaultRole.setName("ROLE_USER");
        roles.add(defaultRole);

        // Criar o usuário com os papéis fornecidos
        return User.builder()
                .email(registerRequest.email())
                .username(registerRequest.username())
                .password(passwordEncoder.encode(registerRequest.password()))
                .roles(roles) // Define os papéis do usuário
                .build();
    }
}

