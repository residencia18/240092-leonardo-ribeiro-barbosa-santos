package configuracao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class TestConfiguracao {

	@Test
	void testSetAlfabeto() {
		Configuracao configuracao = new Configuracao();
		
		//Caso geral: salvar uma senha válida
		String alfabeto = "ABCDEFGHIJ";
		
		try {
			configuracao.setAlfabeto(alfabeto);
		} catch (Exception e1) {
			fail("Gerou excecao indevida");
			e1.printStackTrace();
		}
		
		assertEquals(alfabeto, configuracao.getAlfabeto());
		
		//***************** Caso 1: tentar inserir uma senha null.
		alfabeto = null;
		
		try {
			configuracao.setAlfabeto(alfabeto);
		} catch (Exception e) {
			// temos que ter certeza que a mensagem está correta
			assertEquals("O alfabeto deve possuir mais de 1 caracter", e.getMessage());
		}
		
		assertFalse(configuracao.getAlfabeto()== null);
		
		//***************** Caso 2: tentar inserir uma senha de um caractere.
		alfabeto = "a";
				
		try {
					configuracao.setAlfabeto(alfabeto);
		} catch (Exception e) {
			// temos que ter certeza que a mensagem está correta
			assertEquals("O alfabeto deve possuir mais de 1 caracter", e.getMessage());
		}
				
			//não pode ter aceitado esse alfabeto:
			assertNotEquals("a", configuracao.getAlfabeto());
			
			
			//DEFININDO TAMANHO DA SENHA
			
		
			//definindo um alfabeto (o teste do método que define o alfabeto já existe!)
			alfabeto = "abcd";
			try {
				configuracao.setAlfabeto(alfabeto);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}	
			
	@Test
	void testeSetTamanhoSenha(){
		Configuracao configuracao = new Configuracao();
		//Caso geral: um tamanho de senha válido (entre 1 e 4)
		int tam = 2;
		try {
			configuracao.setTamanhoSenha(tam);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			fail("Não deveria gerar exception aqui");
			e1.printStackTrace();
		}
		assertEquals(tam, configuracao.getTamanhoSenha());

		//Caso 1: tentar inserir uma senha de tamanho negativo
		tam = -1;
		try {
			configuracao.setTamanhoSenha(tam);
		} catch (Exception e) {
			assertEquals("Senha deve ter ao menos 1 caracter", e.getMessage());
		}
		//o tamanho da senha não pode ter sido aceito
		assertNotEquals(tam, configuracao.getTamanhoSenha());	

		//Caso 2 versão 2: inserir com sucesso senha de tamanho iguao ao alfabeto (que tem 4 caracteres)
		tam = 4;
		try {
			configuracao.setTamanhoSenha(tam);
		} catch (Exception e) {
			fail("Não era para gerar exception aqui");
		}
		//o tamanho da senha precisa ter sido aceito
		assertEquals(tam, configuracao.getTamanhoSenha());

		//Caso 2 versão 3: tentar inserir senha de tamanho maior que o alfabeto (que agora tem 10 caracteres)
		try {
			configuracao.setAlfabeto("1234567890");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		tam = 11;
		try {
			configuracao.setTamanhoSenha(tam);
		} catch (Exception e) {
			assertEquals("Senha não pode ser maior que o alfabeto (10 caracteres)", e.getMessage());
		}
		//o tamanho da senha não pode ter sido aceito
		assertNotEquals(tam, configuracao.getTamanhoSenha()); 

	}
	
	
	@Test
	void testSetMaxTentativas() {
	    Configuracao configuracao = new Configuracao();

	    // Caso geral: definir o número máximo de tentativas válido (um número não negativo)
	    int maxTentativas = 5;
	    try {
	        configuracao.setMaxTentativas(maxTentativas);
	    } catch (Exception e) {
	        fail("Não deveria gerar exceção aqui");
	        e.printStackTrace();
	    }
	    assertEquals(maxTentativas, configuracao.getMaxTentativas());

	    // Caso 1: tentar definir o número máximo de tentativas para um valor negativo
	    maxTentativas = -1;
	    try {
	        configuracao.setMaxTentativas(maxTentativas);
	    } catch (Exception e) {
	        assertEquals("O número máximo de tentativas deve ser pelo menos 0", e.getMessage());
	    }
	    // O número máximo de tentativas não deve ter sido aceito
	    assertNotEquals(maxTentativas, configuracao.getMaxTentativas());
	}

	

}

