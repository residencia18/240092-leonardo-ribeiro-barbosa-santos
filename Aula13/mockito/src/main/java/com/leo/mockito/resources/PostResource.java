package com.leo.mockito.resources;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leo.mockito.domain.Post;
import com.leo.mockito.dto.PostDTO;

import com.leo.mockito.services.PostService;

@RestController
@RequestMapping
public class PostResource {
	
	@Autowired
	private  PostService service;
	
	
	 @GetMapping("/posts")
	    public  ResponseEntity<PostDTO> listAll(
	    		@RequestParam(defaultValue = "0") int page,
	    		@RequestParam(defaultValue = "10")int size){
		 Pageable pageable = PageRequest.of(page, size);
		 Page<Post> post = service.listAll(pageable);
		 
		 if(post.isEmpty()) {
			 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		 }
					return new ResponseEntity<PostDTO>((PostDTO) post.getContent(), HttpStatus.OK);
		 
	 }
	 
}
