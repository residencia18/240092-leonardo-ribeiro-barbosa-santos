package com.leo.mockito.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.leo.mockito.domain.User;
import com.leo.mockito.repositories.UserRepository;
import com.leo.mockito.services.exceptions.ObjectNotFoundException;




@Service	
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;
	
	
	
	@Override
	public User findById(Integer id) {
		java.util.Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado."));
	}
	
	public List<User> findAll() {
		return repository.findAll();
	}

}
	