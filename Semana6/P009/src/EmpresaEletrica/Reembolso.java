package EmpresaEletrica;

import java.util.Date;

public class Reembolso {
	 private Date data;
	 private double valor;
	 private Fatura fatura;

	    public Reembolso(double valor) {
	        this.valor = valor;
	        this.data = new Date(); 
	    }
	    
	    
	    
	    
	    public void registrarReembolso(double valorExcedente) {
	        double valorReembolso = valorExcedente;
	        Reembolso novoReembolso = new Reembolso(valorReembolso);
	        // Adicionar o novo reembolso à lista de reembolsos da fatura
	        fatura.getReembolsos().add(novoReembolso);
	        System.out.println("Reembolso de " + valorExcedente + " registrado com sucesso.");
	    }

	  
	    public Date getData() {
	        return data;
	    }

	    public void setData(Date data) {
	        this.data = data;
	    }

	    public double getValor() {
	        return valor;
	    }

	    public void setValor(double valor) {
	        this.valor = valor;
	    }
}
