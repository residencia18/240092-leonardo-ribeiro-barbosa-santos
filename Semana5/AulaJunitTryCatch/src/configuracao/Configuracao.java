
package configuracao;

public class Configuracao {
	private String nome;
	private String alfabeto;
	private int tamanhoSenha;
	private int maxTentativas;

	
	
	
	
	
	public String getAlfabeto() {
		return alfabeto;
	}

	public void setAlfabeto(String alfabeto) throws Exception {
		
		if ((alfabeto == null) || (alfabeto.length() < 2)){
			Exception e = new Exception("O alfabeto deve possuir mais de 1 caracter");
			 throw e;
		}
				
		this.alfabeto = alfabeto;
	}
	
	
	
	
	
	
	
	public int getTamanhoSenha() {
		return tamanhoSenha;
	}

	public void setTamanhoSenha(int tamanhoSenha) throws Exception {
	    if (tamanhoSenha <= 0) {
	        Exception e = new Exception("Senha deve ter ao menos 1 caracter");
	        throw e;
	    }
	    
	    // Verificar se o alfabeto está definido e se o tamanho da senha é menor ou igual ao tamanho do alfabeto
	    if (alfabeto != null && tamanhoSenha > alfabeto.length()) {
	        Exception e = new Exception("Senha não pode ser maior que o alfabeto (" + alfabeto.length() + " caracteres)");
	        throw e;
	    }

	    this.tamanhoSenha = tamanhoSenha;
	}
	
	
	
	

	



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	
	
	
	
	
	
	
	

	public int getMaxTentativas() {
		return maxTentativas;
	}

	public void setMaxTentativas(int maxTentativas) throws Exception {
	    if (maxTentativas < 0) {
	        Exception e = new Exception("O número máximo de tentativas deve ser pelo menos 0");
	        throw e;
	    }
	    
	    this.maxTentativas = maxTentativas;
	}

	
	
	
	
	
	
}
