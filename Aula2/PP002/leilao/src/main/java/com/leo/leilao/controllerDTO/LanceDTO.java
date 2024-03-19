package com.leo.leilao.controllerDTO;

import com.leo.leilao.modelo.Lance;
import com.leo.leilao.modelo.Leilao;

public class LanceDTO {

	private Long id;
	private Leilao leilao;
	private double valor;
	
	public LanceDTO(Lance lance) {
		this.id = lance.getId();
		this.leilao = lance.getLeilao();
		this.valor = lance.getValor();
	}

	public Long getId() {
		return id;
	}

	public Leilao getLeilao() {
		return leilao;
	}

	public double getValor() {
		return valor;
	}
	
	
	
}
