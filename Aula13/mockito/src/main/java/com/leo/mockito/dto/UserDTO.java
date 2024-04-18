package com.leo.mockito.dto;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.leo.mockito.domain.Post;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class UserDTO {

	private Integer id;
	private String name;
	private String email;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	
    private List<Post> post;

	
}