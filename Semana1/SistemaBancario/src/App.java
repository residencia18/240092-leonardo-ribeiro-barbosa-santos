

public class App {
  	
    Conta conta;

	
	public static void main(String[] args) {
		
	Conta conta1 = new Conta("Leonardo");
    
    System.out.println();
    conta1.depositar(10);
    
    conta1.verificarSaldo();
    


    Conta conta2 = new Conta("João");

    conta2.saldo = 0;

    conta1.transferir(conta2, 30);

    conta2.verificarSaldo();
    conta1.verificarSaldo();

		
		
		
		
		
		
	

		
	}
}
