package EmpresaCOELHO;

public class Imovel {
	private String endereco;
    private double consumoAtual;
    private double consumoAnterior;
    private String matricula;

    public Imovel(String endereco, double consumoAtual, double consumoAnterior, String matricula) {
        this.endereco = endereco;
        this.consumoAtual = consumoAtual;
        this.consumoAnterior = consumoAnterior;
        this.matricula = matricula;
    }

    // Getters e Setters
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getConsumoAtual() {
        return consumoAtual;
    }

    public void setConsumoAtual(double consumoAtual) {
        this.consumoAtual = consumoAtual;
    }

    public double getConsumoAnterior() {
        return consumoAnterior;
    }

    public void setConsumoAnterior(double consumoAnterior) {
        this.consumoAnterior = consumoAnterior;
    }

    public double calcularConsumoPeriodo() {
        return consumoAtual - consumoAnterior;
    }
    public String getMatricula() {     
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
