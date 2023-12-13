import javax.xml.crypto.Data;

public class Conta {
	String titular;
	int numeroConta;
	String agencia;
	double saldo;
	Data dataAbertura;
	
	
	

	public Conta(String titular) {
        this.titular = titular;
		this.saldo = 0.00;
        
    }



    // Metodos
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


	public void verificarSaldo(){
		System.out.println("Saldo da conta: " + this.saldo);
	}

	public boolean transferir(Conta destinatario, double valor){
		boolean retirar = this.sacar(valor);
		if(retirar == true){
			return true;
		}
		else {
			
            destinatario.depositar(valor);
			return false;
        }
	
	}

	//gets e sets
	public String getTitular() {
		return titular;
	}


	public void setTitular(String titular) {
		this.titular = titular;
	}


	public int getNumeroConta() {
		return numeroConta;
	}


	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}


	public String getAgencia() {
		return agencia;
	}


	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}


	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


	public Data getDataAbertura() {
		return dataAbertura;
	}


	public void setDataAbertura(Data dataAbertura) {
		this.dataAbertura = dataAbertura;
	}



}

 
