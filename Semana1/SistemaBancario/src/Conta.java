public class Conta {
	//Conta com atributos privados
	private String titular;
	private double saldo;
	private int cpf;
	
	
	
	//construtor para exigir titular e ja inicia a conta com valor 0
	public Conta(String titular) {
        this.titular = titular;
		this.saldo = 0;
        
    }



    // Metodos
	public boolean sacar(Double valor) throws
	SaldoInvalidException {
		if(this.saldo < valor) {
		throw new SaldoInvalidException("Valor insuficiente");
		}
		else {
			System.out.println("Transferência realizado com sucesso!");
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


	public void verificarSaldo(){
		System.out.println("Saldo da conta: " + this.saldo + ", Titular: " +getTitular());
	}

	public boolean transferir(Conta destinatario, double valor) throws SaldoInvalidException{
		boolean retirar = this.sacar(valor);
		if(retirar == true){
			return true;
		}
		else {
			
            destinatario.depositar(valor);
			return false;
        }
	
	}


	// gets e sets
	public String getTitular() {
		return titular;
	}



	public void setTitular(String titular) {
		this.titular = titular;
	}



	public double getSaldo() {
		return saldo;
	}



	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}



	public int getCpf() {
		return cpf;
	}



	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	


}

 
