
public class Imovel {
	private int matricula;
	private String endereço;
	private double ultimaLeitura;
	private double penultimaFatura;
	
	
	
	
	
	public Imovel(int matricula, String endereço, double ultimaLeitura, double penultimaFatura) {
		super();
		this.matricula = matricula;
		this.endereço = endereço;
		this.ultimaLeitura = ultimaLeitura;
		this.penultimaFatura = penultimaFatura;
	}

	
	
	public void incluirImovel() {
		
	}
	
	
	public void consultarImovel() {
		
	}
	
	
	public void listarImovel() {
		
	}
	
	
	public void excluirImovel() {
		
	}
	
	
	public void alterarImovel() {
		
	}




	
	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}





	public String getEndereço() {
		return endereço;
	}

	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}






	public double getUltimaLeitura() {
		return ultimaLeitura;
	}

	public void setUltimaLeitura(double ultimaLeitura) {
		this.ultimaLeitura = ultimaLeitura;
	}





	public double getPenultimaFatura() {
		return penultimaFatura;
	}

	public void setPenultimaFatura(double penultimaFatura) {
		this.penultimaFatura = penultimaFatura;
	}
	
}
