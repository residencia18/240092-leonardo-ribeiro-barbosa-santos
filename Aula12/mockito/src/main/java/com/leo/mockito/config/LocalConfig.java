package com.leo.mockito.config;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.leo.mockito.domain.User;
import com.leo.mockito.repositories.UserRepository;


@Configuration
@Profile("local")
public class LocalConfig {
	
	@Autowired
	private UserRepository repository;
	
	@Bean
	public Object startDB() {
	    Logger logger = Logger.getLogger(LocalConfig.class.getName());
	    logger.info("Iniciando método startDB()...");
	    
		User u1 = new User(null, "Valdir", "valdir@gmail.com", "123", null);
		User u2 = new User(null, "Leo", "leo@hotmail.com", "123", null);
		
		repository.saveAll(List.of(u1, u2));
		logger.info("Método startDB() concluído.");
		
		return new Object();
	}
	

}
