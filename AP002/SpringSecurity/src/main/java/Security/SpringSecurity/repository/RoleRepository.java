package Security.SpringSecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Security.SpringSecurity.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	Optional<Role> findByName(String name); 
}
