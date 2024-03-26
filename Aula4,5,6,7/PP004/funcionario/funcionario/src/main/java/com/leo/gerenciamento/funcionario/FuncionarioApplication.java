package com.leo.gerenciamento.funcionario;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.leo.gerenciamento.funcionario.model.Funcionario;

import lombok.extern.slf4j.XSlf4j;

@XSlf4j
@SpringBootApplication
public class FuncionarioApplication {

	public static final Logger log = LoggerFactory.getLogger(Funcionario.class);
	
	public static void main(String[] args) {
		SpringApplication.run(FuncionarioApplication.class, args);
		log.info("Application started");
	}

}
