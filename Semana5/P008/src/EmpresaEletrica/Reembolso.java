package EmpresaEletrica;

import java.util.Date;

public class Reembolso {
	 private Date data;
	 private double valor;

	    public Reembolso(double valor) {
	        this.valor = valor;
	        this.data = new Date(); 
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
