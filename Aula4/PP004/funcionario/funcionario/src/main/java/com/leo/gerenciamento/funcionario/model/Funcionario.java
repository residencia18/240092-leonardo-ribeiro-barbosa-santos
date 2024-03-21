package com.leo.gerenciamento.funcionario.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Size(min = 3, max = 150, message = "About Me must be between 10 and 200 characters")
    private String nome;
    
    
    private String cargo;
  

}
