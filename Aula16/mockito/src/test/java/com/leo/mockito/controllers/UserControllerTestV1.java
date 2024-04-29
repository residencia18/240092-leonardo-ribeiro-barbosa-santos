package com.leo.mockito.controllers;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.leo.mockito.controllers.UserControllerV1;
import com.leo.mockito.domain.User;
import com.leo.mockito.dto.UserDTO;
import com.leo.mockito.services.UserServiceV1;


@SpringBootTest
class UserControllerTestV1 {

	private static final String PASSWORD = "12345";

	private static final String EMAIL = "valdir@email.com";

	private static final String NAME = "Valdir";

	private static final Integer ID = 1;

	@InjectMocks
	private UserControllerV1 resource;

	@Mock
	private UserServiceV1 service;

	private User user;
	private UserDTO userDTO;


	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		startUser();
	}

	@Test
	void whenTestFindByIdEntaoRetorneSucesso() {
		when(service.findById(anyInt())).thenReturn(user);
		ResponseEntity<UserDTO> response = resource.findById(ID);
		userDTO = response.getBody();

		assertNotNull(response);
		assertNotNull(userDTO);
		assertEquals(ResponseEntity.class, response.getClass());
		assertEquals(UserDTO.class, response.getBody().getClass());


		assertEquals(ID, userDTO.getId());
		assertEquals(NAME, userDTO.getName());
		assertEquals(EMAIL, userDTO.getEmail());
		assertEquals(PASSWORD, userDTO.getPassword());
	}



	@Test
	void testFindAll() {
		fail("Ainda não implementado");
	}

	@Test
	void testCreate() {
		fail("Ainda não implementado");
	}

	@Test
	void testUpdate() {
		fail("Ainda não implementado");
	}

	@Test
	void testDelete() {
		fail("Ainda não implementado");
	}

	private void startUser() {
		user = new User(ID, NAME, EMAIL, PASSWORD, null);
		userDTO = new UserDTO(ID, NAME, EMAIL, PASSWORD, null);
	}

}
