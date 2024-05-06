package Security.SpringSecurity.entity;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
public class PasswordResetToken {
 
	 public PasswordResetToken(String token, User user) {
	        this.token = token;
	        this.user = user;
	        // Exemplo: Token expira em 24 horas a partir da criação
	        this.expiryDate = LocalDateTime.now().plusHours(24);
	    }

	private static final int EXPIRATION = 60 * 24;
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
 
    private String token;
 
    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;
 
    private LocalDateTime expiryDate;
}
