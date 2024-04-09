package com.leo.mockito.services;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.leo.mockito.domain.User;
import com.leo.mockito.dto.UserDTO;
import com.leo.mockito.repositories.UserRepository;


@SpringBootTest
class UserServiceImplTest {

	private static final String PASSWORD = "12345";

	private static final String EMAIL = "valdir@email.com";

	private static final String NAME = "Valdir";

	private static final Integer ID = 1;

	@InjectMocks
	private UserServiceImpl service;
	
	@Mock
	private UserRepository repository;
	
	private User user;
	private UserDTO userDTO;
	private Optional<User> optionalUser;
	
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		startUser();
	}

	@Test
	void testFindByIdThenReturnAnUserInstance() {
		Mockito.when(repository.findById(Mockito.anyInt())).thenReturn(optionalUser);
		
		User response = service.findById(ID);
		assertNotNull(response);
		assertEquals(User.class, response.getClass());
		assertEquals(ID, response.getId());
		assertEquals(NAME, response.getName());
		assertEquals(EMAIL, response.getEmail());
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
		user = new User(ID, NAME, EMAIL, PASSWORD);
		userDTO = new UserDTO(ID, NAME, EMAIL, PASSWORD);
		optionalUser = Optional.of(new User(ID, NAME, EMAIL, PASSWORD));
	}

}
