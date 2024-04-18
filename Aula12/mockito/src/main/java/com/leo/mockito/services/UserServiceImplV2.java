package com.leo.mockito.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;


import com.leo.mockito.repositories.UserRepository;

@Service
@Primary
@Qualifier("v2")
public class UserServiceImplV2 {
	

	@Autowired
	private UserRepository repository;

	
	@DeleteMapping
	public void deleteAll() {
		repository.deleteAll();
	}
	
	
}
