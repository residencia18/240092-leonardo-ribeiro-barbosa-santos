package com.leo.mockito.services;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.leo.mockito.domain.Post;
import com.leo.mockito.repositories.PostRepository;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepository repository;

	@Override
    public Page<Post> listAllByUserId(Integer userId, Pageable pageable) {
        return repository.findAllByUserId(userId, pageable);
    }
	
	

}
