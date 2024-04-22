package com.leo.mockito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.leo.mockito.domain.User;
@EnableCaching
@SpringBootApplication
public class MockitoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MockitoApplication.class, args);
	}

}
