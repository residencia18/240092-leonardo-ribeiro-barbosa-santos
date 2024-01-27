package EmpresaEletrica;
import java.util.ArrayList;
import java.util.List;

public class Imovel {
	private int matricula;
	private String endereco;
	private double ultimaLeitura;
	private double penultimaFatura;
	private List<Cliente> clientes;
	
	
	
	
	public Imovel() {}


	

	
	public Imovel(String endereco) {

		this.endereco = endereco;
		this.clientes = new ArrayList<>() ;
	}

	
	
	
	
	public void incluirCliente(Cliente cliente) {
		clientes.add(cliente);
		System.out.println("Cliente adicionado com sucesso ao imovel " + this.endereco + "Nome do cliente: " + cliente.getNome());
	}
	
	
	public Imovel consultarImovel(String enderecoImovel) {
		if(this.endereco.equalsIgnoreCase(enderecoImovel)) {
			System.out.println("Endereço encontrado: " + this.endereco);
			return this;
		}
		System.out.println("Endereço não encontrado!");
		return null;
	}
	
	
	public void listarImovel() {
		System.out.println("\nEndereço: " + this.endereco);
		System.out.println("Matricula: " + this.matricula);
	}
	
	
	public void excluirCliente() {
		if (clientes != null) {
			System.out.println("O cliente foi removido com sucesso do imovel " + this.endereco);
			clientes = null;
		}
		else {
		System.out.println("Este imovel não possui cliente associado!");
		}
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

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
}
