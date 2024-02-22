package EmpresaEletrica;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ImovelClienteTest {

	@Test
	public void testRegistraLeitura() {
		Imovel imovel = new Imovel(0, "Endereco", new Cliente("Nome", 123456));
		imovel.setUltimaLeitura(100);
		double leituraAtual = 200; 

		imovel.registrarLeitura(leituraAtual);

		assertEquals(100, imovel.getPenultimaLeitura(), 0.01);
		assertEquals(200, imovel.getUltimaLeitura(), 0.01); 
		
	}
}
