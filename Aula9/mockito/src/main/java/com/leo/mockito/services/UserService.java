package com.leo.mockito.services;

import com.leo.mockito.domain.User;

public interface UserService {
	
	User findById(Integer id);
}
