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
	import jakarta.validation.constraints.NotEmpty;
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
		
		@NotEmpty
		private String name;
		
		@NotEmpty
		@Column(unique = true)
		private String email;
		
		@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
		@NotEmpty
		private String password;
		
	
	    // Relacionamento One-to-Many com a entidade Post
		
	    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	    @JsonManagedReference
	    private List<Post> post;
		
		
	}
