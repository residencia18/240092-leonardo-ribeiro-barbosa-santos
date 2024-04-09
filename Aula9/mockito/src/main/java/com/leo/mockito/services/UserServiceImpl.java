package com.leo.mockito.services;


import java.util.List;
import java.util.Optional;

import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.leo.mockito.domain.User;
import com.leo.mockito.dto.UserDTO;
import com.leo.mockito.repositories.UserRepository;
import com.leo.mockito.services.exceptions.DataIntegratyViolationException;
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

	@Override
	public User create(UserDTO obj) {
	    User user = new User();
	    user.setId(obj.getId());
	    user.setName(obj.getName());
	    user.setEmail(obj.getEmail());
	    user.setPassword(obj.getPassword());
	    findByEmail(obj);
	    return repository.save(user);
	}
	
	private void findByEmail(UserDTO obj) {
		Optional<User> user = repository.findByEmail(obj.getEmail());
		if(user.isPresent()) {
			throw new DataIntegratyViolationException("E-mail já cadastrado no sistema");
		}
	}

}
	