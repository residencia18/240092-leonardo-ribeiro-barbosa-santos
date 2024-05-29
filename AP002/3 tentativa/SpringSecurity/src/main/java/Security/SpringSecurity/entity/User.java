package Security.SpringSecurity.entity;


import java.util.List;

import Security.SpringSecurity.validation.ValidPassword;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Email must not be null") // Validação no nível da aplicação
    @Email(message = "Email should be valid")
    @Column(unique = true, nullable = false) // Restrições a nível de banco de dados
    private String email;

    @NotNull(message = "Username must not be null") // Validação no nível da aplicação
    @Size(min = 5, max = 15, message = "Username must be between 5 and 15 characters long")
    @Column(unique = true, nullable = false) // Restrições a nível de banco de dados
    private String username;
    @ValidPassword
    private String password;
    private String role;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true) // Relacionamento bidirecional
    private List<PasswordResetToken> passwordResetTokens; 
    
 // Adicionando @Builder.Default para garantir que os valores padrão sejam mantidos
    @Builder.Default
    private boolean accountNonExpired = true; // Por padrão, não expira

    @Builder.Default
    private boolean accountNonLocked = true; // Por padrão, não bloqueado

    @Builder.Default
    private boolean credentialsNonExpired = true; // Por padrão, credenciais não expiram

    @Builder.Default
    private boolean enabled = true; // Por padrão, habilitado
}
