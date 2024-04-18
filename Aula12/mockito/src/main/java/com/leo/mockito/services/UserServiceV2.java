package com.leo.mockito.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;




@Service
@Qualifier("v2")
public class UserServiceV2 extends UserServiceImplV1{

	
	public void deleteAll() {
	}
	      
	    
}
