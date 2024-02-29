package br.com.prova.leilao.controller.dto;

import br.com.prova.leilao.modelo.Concorrente;

public class CocorrenteDTO {
		
	private Integer id;
	private String nome;
	private String CPF;
	
	
	public CocorrenteDTO (Concorrente concorrente) {
		id = getId();
		nome = getNome();
		CPF = getCPF();
				
	}
	
	
	
	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	
	
	
	
}
