import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private int cpf;
	private String nome;
	List<Imovel> imoveis;
	
	
	public Cliente(String nome, int cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.imoveis = new ArrayList<>();
    }

	
	public void incluirCliente() {
		
	}
	
	
	public void consultarCliente() {
		
	}
	
	
	public void listarCliente() {
		
	}
	
	
	public void excluirCliente() {
		
	}
	
	
	public void alterarCliente() {
		
	}
	
	
	
	
	
	

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}


	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	
	
	public List<Imovel> getImoveis() {
		return imoveis;
	}

	public void setImoveis(List<Imovel> imoveis) {
		this.imoveis = imoveis;
	}
}
