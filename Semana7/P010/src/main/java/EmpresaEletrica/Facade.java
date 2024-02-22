package EmpresaEletrica;

import java.util.Date;

public class Facade {



	public static void main(String[] args) {

		Date data = new Date();
		Date DataFechameto = new Date(2024,12,22);
		
		Cliente cliente1 = new Cliente(null, "Leonardo", 967832);
		Imovel imovel1 = new Imovel("ZIZO", cliente1);
		Fatura fatura1 = new Fatura(imovel1, data);
		Pagamento pagamento1 = new Pagamento(fatura1, 100);
		
		
		fatura1.registrarLeitura(15, DataFechameto );
		
		pagamento1.setData(new Date()); 
	
		
		pagamento1.registraPagamento(DataFechameto);





	
		
		
		
	}
}

