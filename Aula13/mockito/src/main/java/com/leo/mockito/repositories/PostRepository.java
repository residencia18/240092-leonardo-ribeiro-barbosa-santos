package com.leo.mockito.repositories;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.leo.mockito.domain.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

	Page<Post> findAll(Pageable pageable);
	
	
}
