package EmpresaEletrica;
import java.util.ArrayList;
import java.util.List;


public class Cliente {
	private int cpf;
	private String nome;
	List<Imovel> imoveis;
	private List<Cliente> clientes = new ArrayList<>();


	public Cliente(String nome, int cpf) {
		this.nome = nome;
		this.cpf = cpf;
		this.imoveis = new ArrayList<>();
	}
	
	
	public Cliente() {}


	

	public void incluirCliente(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("Cliente adicionado com sucesso. Nome: " + cliente.getNome() + ", CPF: " + cliente.getCpf());
    }

    public void listarClientes() {
        System.out.println("Lista de Clientes:");
        for (Cliente cliente : clientes) {
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("Nome: " + cliente.getNome());
            System.out.println();
        }
    }

    public Cliente consultarCliente(String nomeCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nomeCliente)) {
                System.out.println("Nome encontrado: " + cliente.getNome());
                return cliente;
            }
        }
        System.out.println("Nome não encontrado!");
        return null;
    }

    public void excluirCliente(String nomeCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nomeCliente)) {
                clientes.remove(cliente);
                System.out.println("Cliente removido com sucesso.");
                return;
            }
        }
        System.out.println("Cliente não encontrado.");
    }

    public void alterarCliente(String nomeCliente, String novoNome, int novoCpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nomeCliente)) {
                cliente.setNome(novoNome);
                cliente.setCpf(novoCpf);
                System.out.println("Cliente alterado com sucesso. Novo nome: " + cliente.getNome());
                return;
            }
        }
        System.out.println("Cliente não encontrado.");
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
