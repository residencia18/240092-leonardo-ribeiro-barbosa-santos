package com.leo.mockito.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Post {



	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;


	private String content;

	
	// Relacionamento Many-to-One com a entidade User
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
}
