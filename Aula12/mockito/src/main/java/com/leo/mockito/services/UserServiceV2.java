package com.leo.mockito.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.leo.mockito.repositories.UserRepository;


@Service
@Qualifier("v2")
public class UserServiceV2 extends UserServiceImplV1{

	private UserRepository repository;
	
	 public void deleteAll() {
	       repository.deleteAll();
	    }
}
