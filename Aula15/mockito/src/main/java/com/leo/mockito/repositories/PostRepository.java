package com.leo.mockito.repositories;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leo.mockito.domain.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

	

	Page<Post> findAllByUserId(Integer userId, Pageable pageable);
	
	
}
