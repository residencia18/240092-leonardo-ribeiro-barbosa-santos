package com.leo.mockito.resources;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leo.mockito.domain.User;
import com.leo.mockito.dto.UserDTO;
import com.leo.mockito.services.UserService;

@AutoConfigureMockMvc
@SpringBootTest
class UserResourceTest {

	private static final String PASSWORD = "12345";

	private static final String EMAIL = "valdir@email.com";

	private static final String NAME = "Valdir";

	private static final Integer ID = 1;

	@Autowired
	MockMvc mockMvc;
	
	@InjectMocks
	private UserResource resource;
	
	
	@Mock
	private UserService service;
	private User user;
	private UserDTO userDTO;
	


	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		startUser();
		convertToUser(userDTO);
	}

	@Test
	void whenTestFindByIdEntaoRetorneSucesso() throws Exception {
		when(service.findById(anyInt())).thenReturn(user);
		ResponseEntity<UserDTO> response = resource.findById(ID);


		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/user/{id}", ID)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();

		String responseBody = mvcResult.getResponse().getContentAsString();
		assertNotNull(responseBody);

		ObjectMapper objectMapper = new ObjectMapper();
		UserDTO responseUserDTO = objectMapper.readValue(responseBody, UserDTO.class);
		assertNotNull(responseUserDTO);
		
		verify(service).findById(ID);


		assertNotNull(response);
		assertNotNull(userDTO);

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
		userDTO = new UserDTO(ID, NAME, EMAIL, PASSWORD);
	}
	
	private User convertToUser(UserDTO userDTO) {
	    User user = new User();
	    user.setId(userDTO.getId());
	    user.setName(userDTO.getName());
	    user.setEmail(userDTO.getEmail());
	    user.setPassword(userDTO.getPassword());
	    // Adicione aqui quaisquer outros campos que você tenha em UserDTO
	    return user;
	}


}
