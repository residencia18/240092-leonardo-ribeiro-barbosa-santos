package EmpresaEletrica;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Reembolso")
public class Reembolso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date data;
    private double valor;

    @OneToOne
    @JoinColumn(name = "pagamento_id")
    private Pagamento pagamento;

    public Reembolso() {
        this.data = new Date();
    }

 

    public Reembolso(Pagamento pagamento) {
        this();
        this.pagamento = pagamento;
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
