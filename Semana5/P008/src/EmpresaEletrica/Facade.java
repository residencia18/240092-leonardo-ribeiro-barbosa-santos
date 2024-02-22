package EmpresaEletrica;

import java.util.Date;

public class Facade {



	public static void main(String[] args) {
	
		 Date data = new Date();
	        Cliente cliente = new Cliente("jose", 32);
	        Cliente cliente2 = new Cliente("galo", 52);

	        Imovel imovel = new Imovel(12, "rua", cliente);

	        Fatura novafatura = new Fatura(imovel, 20, 10, data);

	        imovel.incluirImovel(imovel);

	        novafatura.registrarLeitura(15);
	        novafatura.registraPagamento(150);
	        

	       
	        
	        novafatura.registrarReembolso();
	        
	        
	        
	        

	
	
		
	
	
	

		
		
		
		
		
		
		
		
	}
}
