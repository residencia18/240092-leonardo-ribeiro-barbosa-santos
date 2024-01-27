package EmpresaEletrica;
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
	
	
	public Cliente() {}


	

	public void incluirImovel(Imovel imovel) {
		imoveis.add(imovel);
		System.out.println("Imóvel adicionado com sucesso ao cliente " + nome + "  Endereço do Imóvel: " + imovel.getEndereço());
	}

	
	 public Cliente consultarCliente(String nomeCliente) {
	        if (this.nome.equalsIgnoreCase(nomeCliente)) {
	        	System.out.println("Nome encontrado: " + this.nome);
	            return this;
	            
	        }
	        System.out.println("Nome não encontrado!");
	        return null;
	    }
	


	 public void listarImoveis() {
		    if (imoveis.isEmpty()) {
		        System.out.println("Este cliente não possui imóveis associados.");
		    } else {
		        System.out.println("Imóveis do cliente " + nome + ":");
		        for (Imovel imovel : imoveis) {
		            System.out.println("Endereço: " + imovel.getEndereço());
		            // Adicione aqui outras informações do imóvel, se necessário
		        }
		    }
	 }



	 public void excluirImovel() {
		 if (imoveis != null) {
			 System.out.println("Imóvel removido com sucesso do cliente " + nome);
			 imoveis = null;
		 } else {
			 System.out.println("Este cliente não possui imóvel associado.");
		 }
	 }


	 public void alterarCliente(String novoNome, int novoCpf) {
		 setNome(novoNome);
		 setCpf(novoCpf);
		 System.out.println("Cliente alterado com sucesso. Novo nome: " + getNome());
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
