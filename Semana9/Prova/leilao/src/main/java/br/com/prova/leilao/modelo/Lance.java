package br.com.prova.leilao.modelo;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Lance {
	

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String Leilao;
	private String Concorrente;
	private String Valor;
	
	
	
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
