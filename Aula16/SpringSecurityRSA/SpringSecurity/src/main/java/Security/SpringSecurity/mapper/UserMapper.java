package Security.SpringSecurity.mapper;

import org.springframework.stereotype.Service;

import Security.SpringSecurity.dto.RegisterRequest;
import Security.SpringSecurity.entity.User;

@Service
public class UserMapper {

    public User fromRegisterRequest(RegisterRequest registerRequest) {
        return User.builder()
                .email(registerRequest.email())
                .username(registerRequest.username())
                .password(registerRequest.password())
                .role("ROLE_USER")
                .build();
    }

}