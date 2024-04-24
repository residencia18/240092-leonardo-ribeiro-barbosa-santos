package com.leo.mockito.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
//@Table(name = "usuario")
public class User {



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@NotNull(message = "Username must not be null") // Validação no nível da aplicação 
    @Size(min = 5, max = 15, message = "Username must be between 5 and 15 characters long")
	@Column(unique = true, nullable = false) // Restrições a nível de banco de dados
	private String username;
	
	
	@NotNull(message = "Email must not be null") // Validação no nível da aplicação
    @Email(message = "Email should be valid")
	@Column(unique = true, nullable = false)
	private String email;
	
	//@ValidPassword
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@NotEmpty
	private String password;


	// Relacionamento One-to-Many com a entidade Post

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<Post> post;


}
