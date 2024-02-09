package EmpresaEletrica;

import java.util.Date;


public class Pagamento {
	  private Date data;
	  private double valor;
	  private Fatura fatura;
	  public Pagamento(Fatura fatura, double valor) {
	    	  this.fatura = fatura;
	        this.valor = valor;
	        this.data = new Date(); 
	    }
	    
	   

	   
	  public void registraPagamento() {
		    if (!fatura.isQuitada()) {
		        if (Math.abs(fatura.getValor() + valor - fatura.getValorCalculado()) < 0.001) {
		            fatura.setQuitada(true);
		            System.out.println("Pagamento registrado com sucesso de " + valor + ". A fatura foi quitada.");
		        } else if (fatura.getValor() + valor <= fatura.getValorCalculado()) {
		            fatura.setValor(fatura.getValor() + valor);
		            System.out.println("Pagamento registrado com sucesso. Valor restante da fatura: " + (fatura.getValorCalculado() - fatura.getValor()));
		        } else {
		            throw new IllegalStateException("Erro: O valor pago excede o valor da fatura de " +  fatura.getValorCalculado());
		        }
		    } else {
		        throw new IllegalStateException("A fatura já está quitada. Não é possível registrar mais pagamentos.");
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







		public Fatura getFatura() {
			return fatura;
		}







		public void setFatura(Fatura fatura) {
			this.fatura = fatura;
		}







}