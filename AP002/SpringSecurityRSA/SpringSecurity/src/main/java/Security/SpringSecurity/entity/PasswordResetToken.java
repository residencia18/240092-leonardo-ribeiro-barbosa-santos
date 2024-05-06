package Security.SpringSecurity.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class PasswordResetToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String token;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user; // 

    @Column(nullable = false)
    private LocalDateTime createdDate;

    @Column(nullable = false)
    private LocalDateTime expirationDate;


    public PasswordResetToken(String token, User user) {
        this.token = token;
        this.user = user;
        this.createdDate = LocalDateTime.now();
        this.expirationDate = createdDate.plusHours(1); // Por exemplo, validade de 1 hora
    }

    public boolean isExpired() {
        return LocalDateTime.now().isAfter(expirationDate);
    }

	

}

