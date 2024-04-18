package com.leo.mockito.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.leo.mockito.domain.User;
import com.leo.mockito.dto.UserDTO;
import com.leo.mockito.repositories.UserRepository;
import com.leo.mockito.services.exceptions.DataIntegratyViolationException;
import com.leo.mockito.services.exceptions.ObjectNotFoundException;




@Service	
@Primary
@Qualifier("v1")
public class UserServiceImplV1 implements UserServiceV1 {

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
	
	
	
	@Override
	public User update(UserDTO obj) {
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
		if(user.isPresent() && !user.get().getId().equals(obj.getId())) {
			throw new DataIntegratyViolationException("E-mail já cadastrado no sistema");
		}
	}

	@Override
	public void delete(Integer id) {
		findById(id);
		repository.deleteById(id);
	}

	

}
	