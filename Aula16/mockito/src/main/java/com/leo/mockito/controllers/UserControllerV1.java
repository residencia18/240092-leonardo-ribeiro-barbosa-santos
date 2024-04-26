package com.leo.mockito.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.leo.mockito.domain.User;
import com.leo.mockito.dto.UserDTO;
import com.leo.mockito.services.UserServiceV1;

@RestController
@RequestMapping(value = "/v1/user")
public class UserControllerV1 {

	private static final String ID = "/{id}";
	@Autowired
	private UserServiceV1 service;

	@GetMapping(value = UserControllerV1.ID)
	public ResponseEntity<UserDTO> findById(@PathVariable Integer id){
		User user = service.findById(id);
		UserDTO userDTO = convertToDTO(user); // Método para converter User para UserDTO
		return ResponseEntity.ok().body(userDTO);
	}


	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		return ResponseEntity.ok(service.findAll().stream()
				.map(user -> new UserDTO(user.getId(), user.getUsername(), user.getEmail(), user.getPassword(), null))
				.collect(Collectors.toList()));
	}

	@PostMapping
	public ResponseEntity<UserDTO> create(@RequestBody UserDTO obj) {
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest().path(UserControllerV1.ID).buildAndExpand(service.create(obj).getId()).toUri();
		return ResponseEntity.created(uri).build();

	}

	 @PutMapping(value = UserControllerV1.ID)
	    public ResponseEntity<UserDTO> update(@PathVariable Integer id, @RequestBody UserDTO obj) {
	        obj.setId(id); // Define o ID do objeto com o ID passado na URL
	        return ResponseEntity.ok(convertToDTO(service.update(obj))); 
	     // Chama o serviço para atualizar o usuário e retorna diretamente o ResponseEntity com o objeto UserDTO
	    }
	 
	 @DeleteMapping(value = UserControllerV1.ID)
	 public ResponseEntity<UserDTO> delete(@PathVariable Integer id) {
		 service.delete(id);
		 return ResponseEntity.noContent().build();
	 }

	private UserDTO convertToDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setName(user.getUsername());
		userDTO.setEmail(user.getEmail());
		userDTO.setPassword(user.getPassword());
		return userDTO;
	}
}
