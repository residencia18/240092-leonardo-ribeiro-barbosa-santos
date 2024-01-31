package EmpresaEletrica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Fatura {
    private Imovel imovel;
    private double leituraAnterior;
    private double leituraAtual;
    private Date dataEmissao;
    private double valorCalculado;
    private boolean quitada;
    private double valorPago;
    private List<Pagamento> pagamentos;
    private List<Reembolso> reembolsos;
    private double valorCalculadoFatura;

    public Fatura(Imovel imovel, double leituraAnterior, double leituraAtual, Date dataEmissao) {
        this.imovel = imovel;
        this.leituraAnterior = leituraAnterior;
        this.leituraAtual = leituraAtual;
        this.dataEmissao = new Date();
        this.valorCalculado = calcularValorFatura();
        this.quitada = false;
        this.pagamentos = new ArrayList<>();
        this.reembolsos = new ArrayList<>();
        this.valorPago = 0.0;
    }

    public double calcularValorFatura() {
        double consumo = leituraAtual - leituraAnterior;
        double precoKwh = 10.0;
        return consumo * precoKwh;
    }

    public void registrarLeitura(double leituraAtual) {
        if (leituraAtual >= imovel.getUltimaLeitura()) {
            imovel.setPenultimaLeitura(imovel.getUltimaLeitura());
            imovel.setUltimaLeitura(leituraAtual);

            Date dataEmissao = new Date();
            double consumo = imovel.getUltimaLeitura() - imovel.getPenultimaLeitura();
            this.valorCalculadoFatura = consumo * 10.0; // Definir o valor calculado da fatura

            Fatura novaFatura = new Fatura(imovel, imovel.getPenultimaLeitura(), imovel.getUltimaLeitura(), dataEmissao);
            novaFatura.setValorCalculado(this.valorCalculadoFatura); // Definir o valor calculado da fatura na nova fatura
            imovel.getFaturas().add(novaFatura);

            System.out.println("Leitura registrada com sucesso para o imóvel: " + imovel.getEndereco());
            System.out.println("Leitura anterior: " + imovel.getPenultimaLeitura());
            System.out.println("Leitura atual: " + imovel.getUltimaLeitura());
            System.out.println("Data de emissão da fatura: " + dataEmissao);
            System.out.println("Valor calculado da fatura: " + valorCalculadoFatura);
        } else {
            System.out.println("Erro ao registrar leitura: a leitura atual é menor que a última leitura.");
        }
    }

    public void registraPagamento(double valor) {
        if (!quitada) {
            if (Math.abs(valorPago + valor - valorCalculadoFatura) < 0.001) {
                quitada = true;
                valorPago += valor;
                System.out.println("Pagamento registrado com sucesso de " + valorPago + ". A fatura foi quitada.");
            } else if (valorPago + valor <= valorCalculadoFatura) { 
                valorPago += valor;
                System.out.println("Pagamento registrado com sucesso. Valor restante da fatura: " + (valorCalculadoFatura - valorPago));
            } else {
                System.out.println("Erro: O valor pago excede o valor da fatura.");
            }
        } else {
            System.out.println("A fatura já está quitada. Não é possível registrar mais pagamentos.");
        }
    }


    
    public void registrarReembolso(double valor) {
        if (quitada && valor > 0) {
            reembolsos.add(new Reembolso(valor));
            System.out.println("Reembolso de " + valor + " registrado com sucesso.");
        } else {
            System.out.println("Não é possível registrar reembolso. A fatura não está quitada ou o valor é inválido.");
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

    public double getValorCalculado() {
        return valorCalculado;
    }

    public void setValorCalculado(double valorCalculado) {
        this.valorCalculado = valorCalculado;
    }

    public boolean isQuitada() {
        return quitada;
    }

    public void setQuitada(boolean quitada) {
        this.quitada = quitada;
    }
    
 

    @Override
    public String toString() {
        return "Fatura{" +
                "imovel=" + imovel +
                ", leituraAnterior=" + leituraAnterior +
                ", leituraAtual=" + leituraAtual +
                ", dataEmissao=" + dataEmissao +
                ", valorCalculado=" + valorCalculado +
                ", quitada=" + quitada +
                '}';
    }

	public List<Reembolso> getReembolsos() {
		return reembolsos;
	}

	public void setReembolsos(List<Reembolso> reembolsos) {
		this.reembolsos = reembolsos;
	}

	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}

	public double getValorPago() {
		return valorPago;
	}

	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}
}
