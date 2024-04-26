package com.leo.mockito.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leo.mockito.domain.users.AuthenticationDTO;
import com.leo.mockito.domain.users.LoginResponseDTO;
import com.leo.mockito.domain.users.RegisterDTO;
import com.leo.mockito.domain.users.Users;
import com.leo.mockito.infra.security.TokenService;
import com.leo.mockito.repositories.UsersRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	UsersRepository repository;
	
	@Autowired
	TokenService tokenService;
	
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
		var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
		var auth = this.authenticationManager.authenticate(usernamePassword);
		
		var token = tokenService.generateToken((Users)auth.getPrincipal());
		
		return ResponseEntity.ok(new LoginResponseDTO(token));
	}
	
	@PostMapping("/register")
	public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
		if(this.repository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();
		
		String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
		Users newUsers = new Users(data.login(), encryptedPassword, data.role());
		
		this.repository.save(newUsers);
		
		return ResponseEntity.ok().build();
	}
}
