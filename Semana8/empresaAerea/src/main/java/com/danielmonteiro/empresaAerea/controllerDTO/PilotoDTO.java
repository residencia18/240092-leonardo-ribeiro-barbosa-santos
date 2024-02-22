package com.danielmonteiro.empresaAerea.controllerDTO;

import com.danielmonteiro.empresaAerea.model.Piloto;

public class PilotoDTO {

	private Long id;
	private Long numBreve;
	private String nome;
	
	//Construtor
	public PilotoDTO(Piloto piloto) {
		super();
		this.id = piloto.getId();
		this.numBreve = piloto.getNumBreve();
		this.nome = piloto.getNome();
	}

	//Gets DTO
	public Long getId() {
		return id;
	}

	public Long getNumBreve() {
		return numBreve;
	}

	public String getNome() {
		return nome;
	}
	
	
	
	
	
}
