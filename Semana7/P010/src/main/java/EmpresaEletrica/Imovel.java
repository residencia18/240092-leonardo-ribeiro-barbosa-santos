package EmpresaEletrica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Imovel")
public class Imovel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "matricula")
    private int matricula;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "ultima_leitura")
    private double ultimaLeitura;

    @Column(name = "penultima_leitura")
    private double penultimaLeitura;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "imovel", cascade = CascadeType.ALL)
    private List<Fatura> faturas;

    public Imovel() {}

    public Imovel(String endereco, Cliente cliente) {
        this.endereco = endereco;
        this.cliente = cliente;
        this.faturas = new ArrayList<>();
    }






    public void incluirCliente(Cliente cliente) {
        this.cliente = cliente;
        System.out.println("Cliente " + cliente.getNome() + " associado ao imóvel com sucesso.");
    }

    
    public void listarCliente() {
        System.out.println("Cliente associado ao imóvel:");
        System.out.println("Nome: " + cliente.getNome());
        System.out.println("CPF: " + cliente.getCpf());
        System.out.println();
    }

   
    public Cliente consultarCliente() {
        return cliente;
    }

   
    public void alterarCliente(Cliente novoCliente) {
        this.cliente = novoCliente;
        System.out.println("Cliente associado ao imóvel alterado com sucesso para " + novoCliente.getNome());
    }

    
    public void removerCliente() {
        this.cliente = null;
        System.out.println("Cliente removido do imóvel com sucesso.");
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






		public List<Fatura> getFaturas() {
			return faturas;
		}

		public void setFaturas(List<Fatura> faturas) {
			this.faturas = faturas;
		}


}