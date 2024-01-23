package TestConfiguracao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import configuracao.Configuracao;
import configuracao.ListaConfiguracoes;





class ListaConfiguracoesTest {
	
	
	
	
	void testNovaConfiguracao() {
		Configuracao c0 = new Configuracao();
		c0.setNome("Conf 0");
		Configuracao c1 = new Configuracao();
		c1.setNome("Conf 1");
		Configuracao c2 = new Configuracao();
		c2.setNome("Conf 2");
		ListaConfiguracoes listaConfiguracoes = new ListaConfiguracoes();
		
		//caso geral: acrescentar uma lista perfeitamente válida
		assertEquals(0, listaConfiguracoes.getLista().size());
		try {
			listaConfiguracoes.novaConfiguracao(c0);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			fail("Não deveria gerar exceção");
		}
		try {
			listaConfiguracoes.novaConfiguracao(c1);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			fail("Não deveria gerar exceção");
		}
		try {
			listaConfiguracoes.novaConfiguracao(c2);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			fail("Não deveria gerar exceção");
		}
		assertEquals(3, listaConfiguracoes.getLista().size());
		assertEquals("Conf 0", listaConfiguracoes.getLista().get(0).getNome());
		assertEquals("Conf 1", listaConfiguracoes.getLista().get(1).getNome());
		assertEquals("Conf 2", listaConfiguracoes.getLista().get(2).getNome());
		

	
	}
		
    
	
}
