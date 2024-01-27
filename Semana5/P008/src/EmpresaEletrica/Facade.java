package EmpresaEletrica;

public class Facade {



	public static void main(String[] args) {
		
		Cliente cliente = new Cliente("Joaquin", 687);
		Imovel imovel1 =  new Imovel ("Travessa Santa rita");
		Imovel imovel2 = new Imovel ("Felix Mendonça");
		
		cliente.incluirImovel(imovel1);
		cliente.incluirImovel(imovel2);
		
		cliente.listarImoveis();
		
		cliente.alterarCliente("João", 765);
		
		
		
		
		
		
		
		
		
		
	}
}
