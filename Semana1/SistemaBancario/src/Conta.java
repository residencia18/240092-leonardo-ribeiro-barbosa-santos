public class Conta {
	int numeroConta;
	String agencia;
	double saldo;
	String dataAbertura;
	
	
	
	public boolean sacar(Double valor) {
		if(this.saldo < valor) {
            System.out.println("Valor insuficiente");
			return true;
		}
		else {
            this.saldo = this.saldo - valor;
			return false;
		}
	}
	
	
	public void depositar(double valor) {
		this.saldo = this.saldo + valor;
		
	}
	


	public void calcularRendimento() {
        if(this.saldo > 0){
            this.saldo += this.saldo * 0.1;
        }
    }
   
}

