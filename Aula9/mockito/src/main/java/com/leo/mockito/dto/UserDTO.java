package com.leo.mockito.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserDTO {

	private Integer id;
	private String name;
	private String email;
	private String password;
	
	
}
