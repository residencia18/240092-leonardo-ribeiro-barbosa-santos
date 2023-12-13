

public class App {
  	
    Conta conta;

	
	public static void main(String[] args) throws SaldoInvalidException {
	try {	
	Conta conta1 = new Conta("Leonardo");

    
    conta1.setCpf(1213243249);
    System.out.println("Nova conta criada do titular: " + conta1.getTitular() + "\nCPF: " + conta1.getCpf());
    conta1.verificarSaldo();

    System.out.println("Deposito realizado!");
    conta1.depositar(10);
    conta1.verificarSaldo();


    


    Conta conta2 = new Conta("João");
    conta2.setCpf(2132432430);
    System.out.println("Nova conta criada com sucesso! Titular: " + conta2.getTitular() + "\nCPF: " + conta2.getCpf());
    conta2.verificarSaldo();
    conta2.setSaldo(0);

    System.out.println("Tentativa de Deposito...");
    conta1.transferir(conta2, 2.50);
   
    conta2.verificarSaldo();
    conta1.verificarSaldo();

    System.out.println("Tentativa de saque...");
    conta2.sacar(1.0);
    conta2.verificarSaldo();

    }catch(Exception e){
            System.out.println("Erro! " + e.getMessage());
        }

	}
}
