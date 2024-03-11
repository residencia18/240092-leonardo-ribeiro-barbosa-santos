package configuracao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestConfiguracao {

	void testeAlfabeto() {
		Configuracao configuracao = new Configuracao();
		String senha =  "ABCDEFGHJ";
		configuracao.setAlfabeto(senha);
	try {
		configuracao.setAlfabeto(senha);
	}catch(Exception el) {
		fail ("Gerou exceção indevida");
		el.printStackTrace();
		
	}
	assertEquals(senha, configuracao.getAlfabeto());
	
	senha = null;
	try {
		configuracao.setAlfabeto(senha);
	}catch(Exception e) {
		assertEquals("O alfabeto deve possuir mais de 1 caracter", e.getMessage());
	}
	assertFalse(configuracao.getAlfabeto()== null);
		
	
	
	
	}
	
}
