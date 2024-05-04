package Security.SpringSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Security.SpringSecurity.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
