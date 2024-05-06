package Security.SpringSecurity.mapper;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import Security.SpringSecurity.dto.RegisterRequest;
import Security.SpringSecurity.entity.Role;
import Security.SpringSecurity.entity.User;
import Security.SpringSecurity.repository.RoleRepository;

@Service
public class UserMapper {
	private final PasswordEncoder passwordEncoder;
	private final RoleRepository roleRepository;
	
    public UserMapper(PasswordEncoder passwordEncoder,RoleRepository roleRepository) {
        this.passwordEncoder = passwordEncoder;
		this.roleRepository = roleRepository;
    }

    public User fromRegisterRequest(RegisterRequest registerRequest) {
        // Buscar o papel 'ROLE_USER' no banco de dados
        Role defaultRole = roleRepository.findByName("ROLE_USER")
                             .orElseThrow(() -> new IllegalArgumentException("Default role not found"));

        Set<Role> roles = new HashSet<>();
        roles.add(defaultRole);

        return User.builder()
                   .email(registerRequest.email())
                   .username(registerRequest.username())
                   .password(passwordEncoder.encode(registerRequest.password()))
                   .roles(roles)
                   .build();
    }
}

