package com.leo.mockito.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.leo.mockito.domain.User;
import com.leo.mockito.repositories.UserRepository;




@Service	
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;
	
	
	
	@Override
	public User findById(Integer id) {
		java.util.Optional<User> obj = repository.findById(id);
		return obj.orElse(null);
	}

}
	