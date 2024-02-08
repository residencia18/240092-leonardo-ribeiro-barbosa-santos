package EmpresaEletrica;

import java.util.Date;

public class Reembolso {
	 private Date data;
	 private double valor;
	 private Pagamento pagamento;
	 

	 
	 public Reembolso(Pagamento pagamento) {
	        this.pagamento = pagamento;
	        this.data = new Date();
	    }
	    
	    public void registrarReembolso() {
	        if (pagamento != null && pagamento.getFatura() != null) {
	            if (pagamento.getValor() > pagamento.getFatura().getValorCalculado()) {
	                double valorReembolso = pagamento.getValor() - pagamento.getFatura().getValorCalculado();
	                System.out.println("Reembolso registrado com sucesso no valor de " + valorReembolso + ".");
	                pagamento.getFatura().setQuitada(true);
	            } else {
	                System.out.println("Não há reembolso a ser feito.");
	            }
	        } else {
	            System.out.println("Erro: Não é possível registrar um reembolso sem um pagamento associado.");
	        }
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
