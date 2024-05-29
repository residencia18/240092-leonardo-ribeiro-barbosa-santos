package Security.SpringSecurity.entity;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class BlacklistedToken {
    @Id
    @Column(length = 1024)
    private String token;
    
    private Instant blacklistedAt;
    
    public BlacklistedToken(String token) {
        this.token = token;
    }

	
}