package EmpresaEletrica;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Fatura")
public class Fatura {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "imovel_id", nullable = false)
    private Imovel imovel;

    @Column(name = "leitura_anterior")
    private double leituraAnterior;

    @Column(name = "leitura_atual")
    private double leituraAtual;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_emissao", nullable = false)
    private Date dataEmissao;

    @Column(name = "valor")
    private double valor;

    @Column(name = "quitada")
    private boolean quitada;

    @OneToMany(mappedBy = "fatura", cascade = CascadeType.ALL)
    private List<Pagamento> pagamentos;

    @Column(name = "valor_calculado")
    private double valorCalculado;

    @Column(name = "leitura_registrada")
    private boolean leituraRegistrada;

    public Fatura() {
        this.dataEmissao = new Date();
        this.leituraRegistrada = false;
    }

    public Fatura(Imovel imovel, Date dataEmissao) {
        this.dataEmissao = dataEmissao;
        this.imovel = imovel;
    }





    public double calcularValorFatura() {
        double consumo = Math.abs(imovel.getUltimaLeitura() - imovel.getPenultimaLeitura());
        double precoKwh = 10.0;
        return consumo * precoKwh;
    }

    public void registrarLeitura(double leitura) {
        if (!leituraRegistrada) { // Verifica se a leitura já foi registrada
            // Atualiza a leitura do imóvel
            imovel.setPenultimaLeitura(imovel.getUltimaLeitura());
            imovel.setUltimaLeitura(leitura);
            
            // Atualiza a leitura atual da fatura
            this.leituraAtual = leitura;

            // Calcula o valor da fatura com base na leitura atual e anterior
            valorCalculado = calcularValorFatura();

            // Define que a leitura foi registrada
            leituraRegistrada = true;

            // Exibe as informações de registro
            System.out.println("\nLeitura registrada com sucesso para o imóvel: " + imovel.getEndereco());
            System.out.println("Leitura anterior: " + imovel.getPenultimaLeitura());
            System.out.println("Leitura atual: " + leituraAtual); // Alterado para usar a leitura atual da fatura
            System.out.println("Data de emissão da fatura: " + dataEmissao);
            System.out.println("Valor calculado da fatura: " + valorCalculado + "\n");
        } else {
            throw new IllegalStateException("Erro: A leitura já foi registrada para esta fatura.");
        }
    }






    







    
   


   
    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public double getLeituraAnterior() {
        return leituraAnterior;
    }

    public void setLeituraAnterior(double leituraAnterior) {
        this.leituraAnterior = leituraAnterior;
    }

    public double getLeituraAtual() {
        return leituraAtual;
    }

    public void setLeituraAtual(double leituraAtual) {
        this.leituraAtual = leituraAtual;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

  
    public boolean isQuitada() {
        return quitada;
    }

    public void setQuitada(boolean quitada) {
        this.quitada = quitada;
    }
    
 

   
    /*
	public List<Reembolso> getReembolsos() {
		return reembolsos;
	}

	public void setReembolsos(List<Reembolso> reembolsos) {
		this.reembolsos = reembolsos;
	}

	*/
	
	
	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}




	public double getValor() {
		return valor;
	}




	public void setValor(double valor) {
		this.valor = valor;
	}



	public double getValorCalculado() {
		return valorCalculado;
	}



	public void setValorCalculado(double valorCalculado) {
		this.valorCalculado = valorCalculado;
	}

	
}
