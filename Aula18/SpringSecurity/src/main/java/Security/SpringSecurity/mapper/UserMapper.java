package Security.SpringSecurity.mapper;

import org.springframework.stereotype.Service;

import Security.SpringSecurity.dto.RegisterRequest;
import Security.SpringSecurity.entity.Role;
import Security.SpringSecurity.entity.User;

@Service
public class UserMapper {

    public User fromRegisterRequest(RegisterRequest registerRequest) {
    	   User user = User.builder()
                .email(registerRequest.email())
                .username(registerRequest.username())
                .password(registerRequest.password())
                .build();
        
        Role role = new Role();
        role.setName("ROLE_USER"); // Definir o nome da role conforme necessário

        // Adicionar a role ao usuário
        user.getRoles().add(role);

        return user;
    }

}