package com.leo.mockito.resources;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leo.mockito.dto.UserDTO;

import com.leo.mockito.services.PostService;

@RestController
@RequestMapping
public class PostResource {
	
	@Autowired
	private  PostService service;
	
	
	@GetMapping
	public Page<UserDTO> listAll(Pageable pageable){
		return null	;
	}
	
}
