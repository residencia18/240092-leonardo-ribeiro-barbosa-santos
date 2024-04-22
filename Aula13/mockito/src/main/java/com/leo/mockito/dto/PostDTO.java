package com.leo.mockito.dto;

import com.leo.mockito.domain.User;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PostDTO {

	
	private Integer id;
	private String content;
	
	
	private User user;

}
