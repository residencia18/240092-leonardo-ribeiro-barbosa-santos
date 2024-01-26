import java.util.List;

public class Imovel {
	private int matricula;
	private String endereco;
	private double ultimaLeitura;
	private double penultimaFatura;
	private List<Cliente> clientes;
	
	
	
	public Imovel(String endereco) {
		this.endereco = endereco;
	}
	
	public Imovel() {}


	


	public Imovel(int matricula, String endereço, double ultimaLeitura, double penultimaFatura) {
		this.matricula = matricula;
		this.endereco = endereço;
		this.ultimaLeitura = ultimaLeitura;
		this.penultimaFatura = penultimaFatura;
	}

	
	
	public void incluirCliente() {

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
		return endereco;
	}

	public void setEndereço(String endereço) {
		this.endereco = endereço;
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
