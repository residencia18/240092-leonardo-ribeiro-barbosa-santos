package empresaDeOnibus;

public class Passageiros {
	  private String nome;
	    private String tipoCartao;

	    public Passageiros(String nome, String tipoCartao) {
	        this.nome = nome;
	        this.tipoCartao = tipoCartao;
	        
	        
	    }

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getTipoCartao() {
			return tipoCartao;
		}

		public void setTipoCartao(String tipoCartao) {
			this.tipoCartao = tipoCartao;
		}

		
	
	    
	    
}
