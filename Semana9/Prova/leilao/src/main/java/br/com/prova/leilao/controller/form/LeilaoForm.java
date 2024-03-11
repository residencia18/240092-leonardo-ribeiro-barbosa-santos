package br.com.prova.leilao.controller.form;

import br.com.prova.leilao.modelo.Leilao;

public class LeilaoForm {

	private String descricao;
	private String valorMinimo;
	private String status;
	
	
	
	
	public LeilaoForm() {}




	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}




	public String getValorMinimo() {
		return valorMinimo;
	}

	public void setValorMinimo(String valorMinimo) {
		this.valorMinimo = valorMinimo;
	}




	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Leilao toLeilao() {
		Leilao  leilao  = new Leilao();
		leilao.setDescricao(descricao);
		leilao.setValorMinimo(valorMinimo);
		leilao.setStatus(status);
		return leilao;
	}



	
	
}
