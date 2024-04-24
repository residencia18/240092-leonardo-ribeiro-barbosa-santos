	package com.leo.mockito.config;
	
	import java.util.ArrayList;
	import java.util.List;
	import java.util.logging.Logger;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.Configuration;
	import org.springframework.context.annotation.Profile;
	
	import com.leo.mockito.domain.Post;
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
		    
			User u1 = new User(null, "Valdir", "valdir@gmail.com", "123", null  );
			User u2 = new User(null, "Leonardo", "leo@hotmail.com", "123", null);
			
			Post post1 = new Post(null, "noticias", u1);
			Post post2 = new Post(null, "Fofoca", u1);
			
		
		        u1.setPost(new ArrayList<>());
		        u1.getPost().add(post1);
		        u1.getPost().add(post2);
			
			repository.saveAll(List.of(u1, u2));
			logger.info("Método startDB() concluído.");
			
			return new Object();
		}
		
	
	}
