package br.com.prova.leilao.controller.dto;

import br.com.prova.leilao.modelo.Leilao;

public class LeilaoDTO {

	private Integer id;
	private String descricao;
	private String valorMinimo;
	private String status;
	
	
	
	public LeilaoDTO(Leilao leilao) {
		id = leilao.getId();
		descricao = leilao.getDescricao();
		valorMinimo = leilao.getValorMinimo();
		status = leilao.getStatus();
	}



	public Integer getId() {
		return id;
	}


	public String getDescricao() {
		return descricao;
	}


	public String getValorMinimo() {
		return valorMinimo;
	}


	public String getStatus() {
		return status;
	}








}



