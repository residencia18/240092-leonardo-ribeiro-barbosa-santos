package com.leo.faker;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.javafaker.Faker;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class FakerApplication {
	public static final Logger log = LoggerFactory.getLogger(FakerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FakerApplication.class, args);
		
		log.info("....................................Start.....................................");
		
		
		Faker faker = new Faker();
		
		for(int i = 0; i < 10; i++) {
			
		
		String nome = faker.name().fullName();
		String endereco = faker.address().fullAddress();
		String empresa = faker.company().name();

		System.out.println("Nome: " + nome);
		System.out.println("Endereço: " + endereco);
		System.out.println("Empresa: " + empresa);
		}

	}

}
