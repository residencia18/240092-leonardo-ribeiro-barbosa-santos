package Security.SpringSecurity.repository;

import javax.management.relation.Role;

import org.springframework.data.jpa.repository.JpaRepository;



public interface RoleRepository extends JpaRepository<Role, Long> {

}
