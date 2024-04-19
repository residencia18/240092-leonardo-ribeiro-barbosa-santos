package com.leo.mockito.services;

import java.awt.print.Pageable;

import org.hibernate.query.Page;
import org.springframework.stereotype.Service;

@Service
public interface PostService {

	Page ListAll(Pageable pageable);
	
}
