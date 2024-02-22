package EmpresaEletrica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Integer Id;

    @Column(name = "CPF", unique = true, nullable = false)
    private int CPF;

    @Column(name = "Nome", nullable = false)
    private String Nome;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Imovel> imoveis = new ArrayList<>();

    // Construtor padrão
    public Cliente() {}

    // Construtor com todos os campos
    public Cliente(Integer Id, String Nome, int CPF) {
    	this.Id = Id;
        this.Nome = Nome;
        this.CPF = CPF;
        this.imoveis = new ArrayList<>();
    }
    
   	public void incluirImovel(Imovel imovel) {
   	        imoveis.add(imovel);
   	        System.out.println("Imóvel adicionado com sucesso. Endereço: " + imovel.getEndereco() +" ao cliente: " + this.Nome + "\n");
   	    }

   	    public void listarImoveis() {
   	        System.out.println("Lista de Imóveis:");
   	        for (Imovel imovel : imoveis) {
   	            System.out.println("Endereço: " + imovel.getEndereco());
   	    
   	            System.out.println(); 
   	        }
   	    }

   		public Imovel consultarImovel(String endereço) {
   	        for (Imovel imovel : imoveis) {
   	            if (imovel.getEndereco().equalsIgnoreCase(endereço)) {
   	                System.out.println("Imóvel encontrado: " + imovel.getEndereco());
   	                return imovel;
   	            }
   	        }
   	        System.out.println("Imóvel não encontrado!");
   	        return null;
   	    }

   	    public void excluirImovel(String endereço) {
   	        for (Imovel imovel : imoveis) {
   	            if (imovel.getEndereco().equalsIgnoreCase(endereço)) {
   	                imoveis.remove(imovel);
   	                System.out.println("Imóvel removido com sucesso.");
   	                return;
   	            }
   	        }
   	        System.out.println("Imóvel não encontrado.");
   	    }

   	    public void alterarImovel(String endereço, String novoEndereco) {
   	        for (Imovel imovel : imoveis) {
   	            if (imovel.getEndereco().equalsIgnoreCase(endereço)) {
   	                imovel.setEndereco(novoEndereco);
   	                System.out.println("Imóvel alterado com sucesso. Novo endereço: " + imovel.getEndereco());
   	                return;
   	            }
   	        }
   	        System.out.println("Imóvel não encontrado.");
   	    }
	

	





	

	public int getCpf() {
		return CPF;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public int getCPF() {
		return CPF;
	}

	public void setCPF(int cPF) {
		CPF = cPF;
	}

	public void setCpf(int cpf) {
		this.CPF = cpf;
	}


	
	
	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		this.Nome = nome;
	}


	
	
	public List<Imovel> getImoveis() {
		return imoveis;
	}

	public void setImoveis(List<Imovel> imoveis) {
		this.imoveis = imoveis;
	}
}
