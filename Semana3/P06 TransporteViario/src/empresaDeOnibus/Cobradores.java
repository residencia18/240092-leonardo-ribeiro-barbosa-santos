package empresaDeOnibus;


public class Cobradores {
	private String nomeCobrador;
	private int cpfCobrador;
	
	
	
	

	
	

	public Cobradores() {
	}


	

	public Cobradores(String nomeCobrador, int cpfCobrador) {
		
		this.nomeCobrador = nomeCobrador;
		this.cpfCobrador = cpfCobrador;
	}




	public int getCpfCobrador() {
		return cpfCobrador;
	}


	public void setCpfCobrador(int cpfCobrador) {
		this.cpfCobrador = cpfCobrador;
	}


	public String getNomeCobrador() {
		return nomeCobrador;
	}


	public void setNomeCobrador(String nomeCobrador) {
		this.nomeCobrador = nomeCobrador;
	}
	
	
}
