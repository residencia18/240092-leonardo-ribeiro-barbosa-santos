package com.leo.mockito.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
import com.leo.mockito.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

	private static final String ID = "/{id}";
	@Autowired
	private UserService service;

	@GetMapping(value = UserResource.ID)
	public ResponseEntity<UserDTO> findById(@PathVariable Integer id){
		User user = service.findById(id);
		UserDTO userDTO = convertToDTO(user); // Método para converter User para UserDTO
		return ResponseEntity.status(HttpStatus.OK).body(userDTO);

	}


	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		return ResponseEntity.ok(service.findAll().stream()
				.map(user -> new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getPassword()))
				.collect(Collectors.toList()));
	}

	@PostMapping
	public ResponseEntity<User> create(@Valid @RequestBody UserDTO obj, BindingResult result) {
		// Verifica se houve erros de validação no objeto UserDTO
		if (result.hasErrors()) {
			// Se houver erros de validação, retorna uma resposta de erro 400 (BadRequest)
			return ResponseEntity.badRequest().build();
		}

		try {
			// Tenta criar o usuário
			User criarUser = service.create(obj);
			URI uri = ServletUriComponentsBuilder
					.fromCurrentRequest().path(ID).buildAndExpand(criarUser.getId()).toUri();
			// Retorna uma resposta de sucesso com o usuário criado
			return ResponseEntity.created(uri).body(criarUser);
		} catch (Exception e) {
			// Se ocorrer uma exceção durante a criação do usuário, retorna uma resposta de erro 500 (Internal Server Error)
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}



	@PutMapping(value = UserResource.ID)
	public ResponseEntity<UserDTO> update(@PathVariable Integer id, @RequestBody UserDTO obj) {
		obj.setId(id); // Define o ID do objeto com o ID passado na URL
		return ResponseEntity.ok(convertToDTO(service.update(obj))); 
		// Chama o serviço para atualizar o usuário e retorna diretamente o ResponseEntity com o objeto UserDTO
	}

	@DeleteMapping(value = UserResource.ID)
	public ResponseEntity<UserDTO> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
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
