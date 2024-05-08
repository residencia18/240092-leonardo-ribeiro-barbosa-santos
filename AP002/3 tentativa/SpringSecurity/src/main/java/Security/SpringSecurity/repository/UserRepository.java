package Security.SpringSecurity.repository;

import java.util.Optional;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Security.SpringSecurity.entity.User;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final JdbcClient jdbcClient;

    @Transactional
    public Long saveUser(User user) {
        var insertQuery = """
                INSERT INTO users(username, password, email, role) 
                VALUES(?, ?, ?, ?)
                """;
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcClient.sql(insertQuery)
                .param(1, user.getUsername())
                .param(2, user.getPassword())
                .param(3, user.getEmail())
                .param(4, user.getRole())
                .update();
        return keyHolder.getKeyAs(Long.class);
    }

    @Transactional(readOnly = true)
    public Optional<User> findByUsername(String username) {
        try {
            var findQuery = "SELECT id, username, password, role, email FROM users WHERE username = :username";
            return jdbcClient.sql(findQuery).param("username", username).query(User.class).optional();
        } catch (Exception e) {
            // Logar ou tratar o erro
            throw new RuntimeException("Erro ao buscar usuário por username", e);
        }
    }

    
    
    @Transactional(readOnly = true)
    public Optional<User> findByEmail(String email) {
        var findQuery = "SELECT id, username, password, role, email FROM users WHERE email = :email";
        return jdbcClient.sql(findQuery).param("email", email).query(User.class).optional();
    }
    @Transactional
    public void updatePassword(Long userId, String newPassword) {
        var updateQuery = "UPDATE users SET password = ? WHERE id = ?";
        jdbcClient.sql(updateQuery)
                .param(1, newPassword)
                .param(2, userId)
                .update();
    }

	

}