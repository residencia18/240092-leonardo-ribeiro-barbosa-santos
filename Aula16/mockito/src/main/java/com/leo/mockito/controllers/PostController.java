package com.leo.mockito.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leo.mockito.domain.Post;
import com.leo.mockito.dto.PostDTO;

import com.leo.mockito.services.PostService;

@RestController



@RequestMapping(value = "/post")

public class PostController {
	
	@Autowired
	private  PostService service;
	
	@GetMapping("/user/{userId}/post")
	@Cacheable(value = "postsCache", key = "#userId")
	public ResponseEntity<Page<PostDTO>> listAllByUserId(
	    @PathVariable Integer userId,
	    @RequestParam(defaultValue = "0") int page,
	    @RequestParam(defaultValue = "10") int size) {
	    Pageable pageable = PageRequest.of(page, size);
	    Page<Post> postPage = service.listAllByUserId(userId, pageable);

	    if (postPage.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

	    Page<PostDTO> postDTOPage = postPage.map(post -> {
	        PostDTO postDTO = new PostDTO();
	        postDTO.setId(post.getId());
	        postDTO.setContent(post.getContent());
	        postDTO.setUser(post.getUser()); // Assuming user is already mapped in PostDTO
	        return postDTO;
	    });

	    return new ResponseEntity<>(postDTOPage, HttpStatus.OK);
	}

	 
}
