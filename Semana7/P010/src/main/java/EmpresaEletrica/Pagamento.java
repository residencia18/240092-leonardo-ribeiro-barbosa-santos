package EmpresaEletrica;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Pagamento")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Date data;
    private double valor;

    @OneToOne(mappedBy = "pagamento", cascade = CascadeType.ALL)
    private Reembolso reembolso;

	    @ManyToOne
	    @JoinColumn(name = "fatura_id", referencedColumnName = "id") // Aqui especificamos que a coluna referenciada é 'id' da tabela 'Fatura'
	    private  Fatura fatura;

    public Pagamento() {
        this.data = new Date();
    }

    public Pagamento(Fatura fatura, double valor) {
        this();
        this.fatura = fatura;
        this.valor = valor;
    }

	   


    public void registraPagamento(Date data) {
        if (!fatura.isQuitada()) {
            Date dataAtual = new Date(); // Obtém a data atual do sistema
            
            // Verifica se a data de fechamento da fatura é maior que a data de emissão da fatura
            if (fatura.getDataFechamento().after(fatura.getDataEmissao())) {
                if (fatura.getValor() + valor > fatura.getValorCalculado()) {
                    throw new IllegalStateException("O valor pago excede o valor da fatura. Não é possível registrar o pagamento.");
                } else if (Math.abs(fatura.getValor() + valor - fatura.getValorCalculado()) < 0.001 ) {
                    fatura.setQuitada(true);
                    System.out.println("Data e Hora do pagamento: " + data + "\nPagamento registrado com sucesso de " + valor + ". A fatura foi quitada.");
                } else {
                    fatura.setValor(fatura.getValor() + valor);
                    System.out.println("Data e Hora do pagamento: " + data + "\nPagamento registrado com sucesso. Valor restante da fatura: " + (fatura.getValorCalculado() - fatura.getValor() ));
                }
            } else {
                throw new IllegalStateException("A data de fechamento da fatura é anterior ou igual à data de emissão. Não é possível registrar o pagamento.");
            }
        } else {
            throw new IllegalStateException("Data e Hora do pagamento: " + data + "\nA fatura já está quitada. Não é possível registrar mais pagamentos.");
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