package EmpresaCOELHO;

import java.time.LocalDate;

public class Fatura {
	private String matriculaImovel;
    private double leituraAnterior;
    private double leituraAtual;
    private LocalDate dataEmissao;
    private double valorCalculado;
    private boolean estaQuitada;

    public Fatura(String matriculaImovel, double leituraAnterior, double leituraAtual) {
        this.matriculaImovel = matriculaImovel;
        this.leituraAnterior = leituraAnterior;
        this.leituraAtual = leituraAtual;
        this.dataEmissao = LocalDate.now();
        this.valorCalculado = calcularValorFatura();
        this.estaQuitada = false;
    }

    public Fatura(Imovel imovel, double ultimaLeitura) {
		// TODO Stub de construtor gerado automaticamente
	}

	public double calcularValorFatura() {
        return (leituraAtual - leituraAnterior) * 10;
    }

    public void marcarComoQuitada() {
        this.estaQuitada = true;
    }

    public boolean estaQuitada() {
        return estaQuitada;
    }
    
    public String getMatriculaImovel() {
		return matriculaImovel;
	}

	public void setMatriculaImovel(String matriculaImovel) {
		this.matriculaImovel = matriculaImovel;
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

	public LocalDate getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public double getValorCalculado() {
		return valorCalculado;
	}

	public void setValorCalculado(double valorCalculado) {
		this.valorCalculado = valorCalculado;
	}

	public boolean isEstaQuitada() {
		return estaQuitada;
	}

	public void setEstaQuitada(boolean estaQuitada) {
		this.estaQuitada = estaQuitada;
	}

	public boolean isQuitada() {
        return estaQuitada;
    }

    public void registrarPagamento(Pagamento pagamento) {

    }

    @Override
    public String toString() {
        return "Matrícula do Imóvel: " + matriculaImovel +
               "\nData de Emissão: " + dataEmissao +
               "\nLeitura Anterior: " + leituraAnterior +
               "\nLeitura Atual: " + leituraAtual +
               "\nValor Calculado: R$" + valorCalculado +
               "\nQuitada: " + (estaQuitada ? "Sim" : "Não");
    }
}
