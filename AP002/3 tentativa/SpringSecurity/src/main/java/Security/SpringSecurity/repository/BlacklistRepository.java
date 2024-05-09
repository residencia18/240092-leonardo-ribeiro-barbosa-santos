package Security.SpringSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Security.SpringSecurity.entity.BlacklistedToken;



public interface BlacklistRepository extends JpaRepository<BlacklistedToken, String> {
    boolean existsByToken(String token);
}
