package br.com.prova.leilao.controller.dto;

import br.com.prova.leilao.modelo.Lance;



public class LanceDTO {
	
	
	private Integer id;
	private String Leilao;
	private String Concorrente;
	private String Valor;
	
	public LanceDTO(Lance lance) {
		id = lance.getId();
		Leilao = lance.getLeilao();
		Concorrente = lance.getConcorrente();
		Valor = lance.getValor();
	}
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLeilao() {
		return Leilao;
	}
	public void setLeilao(String leilao) {
		Leilao = leilao;
	}
	public String getConcorrente() {
		return Concorrente;
	}
	public void setConcorrente(String concorrente) {
		Concorrente = concorrente;
	}
	public String getValor() {
		return Valor;
	}
	public void setValor(String valor) {
		Valor = valor;
	}
	
	
	
}
