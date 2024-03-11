package com.danielmonteiro.empresaAerea.controllerDTO;

import com.danielmonteiro.empresaAerea.model.Aeroporto;

public class AeroportoDTO {

	private Long id;
	private String ICAO,nome;
	
	//construtor
	public AeroportoDTO(Aeroporto aeroporto) {

		this.id = aeroporto.getId();
		ICAO = aeroporto.getICAO();
		this.nome = aeroporto.getNome();
	}

	//gets DTO
	public Long getId() {
		return id;
	}

	public String getICAO() {
		return ICAO;
	}

	public String getNome() {
		return nome;
	}

	
	
}
