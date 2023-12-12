public class App {
  	Conta conta;

	
	public static void main(String[] args) {
		
	Conta conta = new Conta();
    
    conta.numeroConta = 432432432;
    conta.agencia = "06952";
    System.out.println("Saldo inicial");
    conta.saldo = 100;

    System.out.println("Valor sacado");
    conta.sacar(150.0);

    System.out.println("Valor depositado");
    conta.depositar(1000);

    conta.calcularRendimento();

    System.out.println("Saldo da conta: " + conta.saldo);
  

		
		
		
		
		
		
	

		
	}
}
