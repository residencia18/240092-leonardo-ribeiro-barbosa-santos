package empresaDeOnibus;

public class PontoDeParada {
	private String nome;
	
	
	 public PontoDeParada(String nome) {
		this.nome = nome;
	}


	public void registrarEmbarqueComCartao(Passageiros passageiro, String cartao) {
	        System.out.println("Passageiro " + passageiro.getNome() + " embarcou com o cartão " + passageiro.getTipoCartao() +
	                " no ponto de parada " + this.nome);
	        // Lógica para registrar o embarque com cartão, se necessário.
	    }


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	 
	 
	 
}
