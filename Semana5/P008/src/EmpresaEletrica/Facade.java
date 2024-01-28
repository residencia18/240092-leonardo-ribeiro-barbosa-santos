package EmpresaEletrica;

public class Facade {



	public static void main(String[] args) {
		
		Cliente cliente1 = new Cliente("Joaquin", 687);
		Cliente cliente2 = new Cliente("José", 543);
		
		Imovel imovel1 =  new Imovel ("Travessa Santa rita", cliente1);
		Imovel imovel2 = new Imovel ("Felix Mendonça", cliente1);
		
		Fatura fatura = new Fatura(imovel1, 30.15, 40.20);
		System.out.println("O valor da fatura é: R$" + fatura.getValorCalculado());
		
		
		imovel1.registraLeitura(100);

		
	
		
		
		
		
		
		
		
		
	}
}
