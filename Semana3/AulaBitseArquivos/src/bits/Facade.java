package bits;


public class Facade {
	public static void main(String[] args) {
		String banho1 = args[0];
		String banho2 = args[1];
		System.out.println(banho1);
		System.out.println(banho2);
		
		Crypto c = new Crypto();
		c.processos(banho1, banho2);
	}
}
