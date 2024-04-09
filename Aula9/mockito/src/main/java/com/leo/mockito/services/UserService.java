package com.leo.mockito.services;

import java.util.List;

import com.leo.mockito.domain.User;
import com.leo.mockito.dto.UserDTO;

public interface UserService {
	
	User findById(Integer id);
	List<User> findAll();
	User create (UserDTO obj);
}
