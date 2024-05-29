package Security.SpringSecurity.repository;

import java.util.Optional;


import Security.SpringSecurity.entity.User;


import org.springframework.data.jpa.repository.JpaRepository;
;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email); // Adicione os métodos que precisar
    Optional<User> findByUsername(String username);

}
