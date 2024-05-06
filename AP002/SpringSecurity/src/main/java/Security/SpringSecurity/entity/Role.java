package Security.SpringSecurity.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "roles") 
public class Role {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	
	@Column(unique = true, nullable = false)
	private String name;
	
	@ManyToMany(mappedBy = "roles")
	private Set<User> users = new HashSet<>();

	

}
