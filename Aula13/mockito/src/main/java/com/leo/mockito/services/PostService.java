package com.leo.mockito.services;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.leo.mockito.domain.Post;


@Service
public interface PostService {

	 Page<Post> listAll(Pageable pageable);


	
}
