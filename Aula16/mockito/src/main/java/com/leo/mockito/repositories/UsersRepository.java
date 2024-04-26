package com.leo.mockito.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.leo.mockito.domain.users.Users;

public interface UsersRepository extends JpaRepository<Users, String> {
		
	UserDetails findByLogin(String login);
}
