package Security.SpringSecurity.dto;

import Security.SpringSecurity.validation.ValidPassword;
import lombok.Data;

@Data

public class PasswordDto {

    private String oldPassword;

    private  String token;

    @ValidPassword
    private String newPassword;
}

