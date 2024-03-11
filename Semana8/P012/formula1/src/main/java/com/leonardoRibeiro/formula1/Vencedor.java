package com.leonardoRibeiro.formula1;

public class Vencedor {

	private String pais,nome;
	private Integer numVitorias;
	
	
	public Vencedor(String pais, String nome, Integer numVitorias) {
		this.pais = pais;
		this.nome = nome;
		this.numVitorias = numVitorias;
	}
	//gets e sets
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getNumVitorias() {
		return numVitorias;
	}
	public void setNumVitorias(Integer numVitorias) {
		this.numVitorias = numVitorias;
	}
	
	public void ToString() {
	  System.out.println("País: " + getPais() + "\n" + "Nome: " + getNome() + "\n" + "Numero de Vitorias: " + getNumVitorias());
	}

	
}
