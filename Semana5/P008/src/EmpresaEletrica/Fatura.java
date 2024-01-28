package EmpresaEletrica;

import java.util.Date;

public class Fatura {
	private Imovel imovel;
    private double leituraAnterior;
    private double leituraAtual;
    private Date dataEmissao;
    private double valorCalculado;
    private boolean quitada;

    public Fatura(Imovel imovel, double leituraAnterior, double leituraAtual) {
        this.imovel = imovel;
        this.leituraAnterior = leituraAnterior;
        this.leituraAtual = leituraAtual;
        this.dataEmissao = new Date();
        this.valorCalculado = calcularValorFatura();
        this.quitada = false;
    }

    private double calcularValorFatura() {
        // Cálculo do valor da fatura
        double consumo = leituraAtual - leituraAnterior;
        double precoKwh = 10.0; // Preço por KWh
        return consumo * precoKwh;
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
}
