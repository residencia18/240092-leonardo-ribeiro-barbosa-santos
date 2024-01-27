package EmpresaEletrica;
import java.util.ArrayList;
import java.util.List;

public class Imovel {
	private int matricula;
	private String endereco;
	private double ultimaLeitura;
	private double penultimaFatura;
	private List<Cliente> clientes;
	 private List<Imovel> imoveis = new ArrayList<>();
	
	
	
	
	public Imovel() {}


	

	
	public Imovel(String endereco, Cliente proprietario) {

		this.endereco = endereco;
		this.clientes = new ArrayList<>() ;
	}

	
	
	
	
	  public void incluirImovel(Imovel imovel) {
	        imoveis.add(imovel);
	        System.out.println("Imóvel adicionado com sucesso. Endereço: " + imovel.getEndereço());
	    }

	    public void listarImoveis() {
	        System.out.println("Lista de Imóveis:");
	        for (Imovel imovel : imoveis) {
	            System.out.println("Endereço: " + imovel.getEndereço());
	    
	            System.out.println(); 
	        }
	    }

	    public Imovel consultarImovel(String endereço) {
	        for (Imovel imovel : imoveis) {
	            if (imovel.getEndereço().equalsIgnoreCase(endereço)) {
	                System.out.println("Imóvel encontrado: " + imovel.getEndereço());
	                return imovel;
	            }
	        }
	        System.out.println("Imóvel não encontrado!");
	        return null;
	    }

	    public void excluirImovel(String endereço) {
	        for (Imovel imovel : imoveis) {
	            if (imovel.getEndereço().equalsIgnoreCase(endereço)) {
	                imoveis.remove(imovel);
	                System.out.println("Imóvel removido com sucesso.");
	                return;
	            }
	        }
	        System.out.println("Imóvel não encontrado.");
	    }

	    public void alterarImovel(String endereço, String novoEndereco) {
	        for (Imovel imovel : imoveis) {
	            if (imovel.getEndereço().equalsIgnoreCase(endereço)) {
	                imovel.setEndereço(novoEndereco);
	                System.out.println("Imóvel alterado com sucesso. Novo endereço: " + imovel.getEndereço());
	                return;
	            }
	        }
	        System.out.println("Imóvel não encontrado.");
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
