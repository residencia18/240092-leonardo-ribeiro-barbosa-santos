package com.leo.mockito.services;

import java.awt.print.Pageable;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.leo.mockito.domain.Post;
import com.leo.mockito.repositories.PostRepository;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepository repository;

	
	@Override
	public Page<Post> listAll(Pageable pageable) {
		return repository.findAll(pageable);
	}
	
	

}
