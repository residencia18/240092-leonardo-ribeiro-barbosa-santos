package EmpresaEletrica;
import java.util.ArrayList;
import java.util.List;

public class Imovel {
	private int matricula;
	private String endereco;
	private double ultimaLeitura;
	private double penultimaLeitura;
	private Cliente clientes;
	
	private List<Imovel> imoveis = new ArrayList<>();
	private List<Fatura> faturas;
	
	
	
	
	
	
	
	
	
	public Imovel() {}


	
	  public Imovel(int matricula, String endereco, Cliente clientes) {
		super();
		this.matricula = matricula;
		this.endereco = endereco;
		this.clientes = clientes;
		this.faturas = new ArrayList<>();
	}











	public void incluirImovel(Imovel imovel) {
	        imoveis.add(imovel);
	        System.out.println("Imóvel adicionado com sucesso. Endereço: " + imovel.getEndereco() +" ao cliente: " + clientes.getNome() + "\n");
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

	  
	    




		public int getMatricula() {
			return matricula;
		}





		public void setMatricula(int matricula) {
			this.matricula = matricula;
		}





		public String getEndereco() {
			return endereco;
		}





		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}





		public double getUltimaLeitura() {
			return ultimaLeitura;
		}





		public void setUltimaLeitura(double ultimaLeitura) {
			this.ultimaLeitura = ultimaLeitura;
		}





		public double getPenultimaLeitura() {
			return penultimaLeitura;
		}





		public void setPenultimaLeitura(double penultimaLeitura) {
			this.penultimaLeitura = penultimaLeitura;
		}









		public List<Imovel> getImoveis() {
			return imoveis;
		}





		public void setImoveis(List<Imovel> imoveis) {
			this.imoveis = imoveis;
		}





		public List<Fatura> getFaturas() {
			return faturas;
		}





		public void setFaturas(List<Fatura> faturas) {
			this.faturas = faturas;
		}


}