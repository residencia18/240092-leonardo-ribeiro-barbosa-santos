package com.leo.mockito.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.leo.mockito.domain.User;
import com.leo.mockito.dto.UserDTO;

@Service
@Qualifier("v1")
public interface UserServiceV1 {
	
	User findById(Integer id);
	List<User> findAll();
	User create (UserDTO obj);
	User update (UserDTO obj);
	void delete(Integer id);
}
