
public class Facade {



	public static void main(String[] args) {
		
		Cliente cliente = new Cliente("Joaquin", 687);
		Imovel imovel =  new Imovel ("Traveessa Santa rita");
		cliente.consultarCliente("Joaquin");
		cliente.listarCliente();
		cliente.incluirImovel(imovel);
		cliente.alterarCliente("Jonas", 6);
		cliente.consultarCliente("Joaquin");
		cliente.excluirImovel();
		
		
		
		
		
		
		
		
		
	}
}
