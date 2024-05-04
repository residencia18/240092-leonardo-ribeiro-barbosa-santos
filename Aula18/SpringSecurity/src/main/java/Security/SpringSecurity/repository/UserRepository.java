package Security.SpringSecurity.repository;


import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import Security.SpringSecurity.entity.User;
import Security.SpringSecurity.entity.Role;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserRepository {

	private final JdbcClient jdbcClient;

	@Transactional
	public Long saveUser(User user) {
		var insertQuery = """
				INSERT INTO users(username, password, email) 
				VALUES(?, ?, ?)
				""";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcClient.sql(insertQuery)
		.param(1, user.getUsername())
		.param(2, user.getPassword())
		.param(3, user.getEmail())
		.update(keyHolder);

		// Obter o ID do usuário recém-criado
		Long userId = keyHolder.getKeyAs(Long.class);

		// Inserir os papéis do usuário na tabela de junção
		for (Role role : user.getRoles()) {
			var insertRoleQuery = """
					INSERT INTO user_roles(user_id, role_id) 
					VALUES(?, ?)
					""";
			jdbcClient.sql(insertRoleQuery)
			.param(1, userId)
			.param(2, role.getId()) // Você precisará do ID do papel
			.update();
		}

		return userId;
	}

	@Transactional(readOnly = true)
	public Optional<User> findByUsername(String username) {
		var findQuery = """
				SELECT id, username, password, email 
				FROM users 
				WHERE username = ?
				""";
		Optional<User> userOpt = jdbcClient.sql(findQuery)
				.param(1, username)
				.query(User.class)
				.optional();

		if (userOpt.isPresent()) {
			var user = userOpt.get();

			// Buscar os papéis do usuário
			var findRolesQuery = """
					SELECT role_id 
					FROM user_roles 
					WHERE user_id = ?
					""";
			var roleIds = jdbcClient.sql(findRolesQuery)
					.param(1, user.getId())
					.query(Long.class)
					.list();

			Set<Role> roles = new HashSet<>();
			for (Long roleId : roleIds) {
				// Obter o nome do papel pelo ID
				var findRoleNameQuery = """
						SELECT name 
						FROM roles 
						WHERE id = ?
						""";
				String roleName = jdbcClient.sql(findRoleNameQuery)
						.param(1, roleId)
						.query(String.class)
						.single();

				Role role = new Role();
				role.setId(roleId);
				role.setName(roleName);
				roles.add(role);
			}

			user.setRoles(roles);
		}

		return userOpt;
	}
}
