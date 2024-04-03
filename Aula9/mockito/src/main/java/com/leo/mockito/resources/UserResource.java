package com.leo.mockito.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leo.mockito.domain.User;
import com.leo.mockito.dto.UserDTO;
import com.leo.mockito.services.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable Integer id){
	    User user = service.findById(id);
	    UserDTO userDTO = convertToDTO(user); // Método para converter User para UserDTO
	    return ResponseEntity.ok().body(userDTO);
	}
	
	private UserDTO convertToDTO(User user) {
	    UserDTO userDTO = new UserDTO();
	    userDTO.setId(user.getId());
	    userDTO.setName(user.getName());
	    userDTO.setEmail(user.getEmail());
	    userDTO.setPassword(user.getPassword());
	    return userDTO;
	}
}
