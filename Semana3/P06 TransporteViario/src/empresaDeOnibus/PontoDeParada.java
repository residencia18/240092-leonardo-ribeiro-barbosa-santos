package empresaDeOnibus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PontoDeParada {
	private String nome;
	private List<String> passageirosEmbarcados;
	
	
	

	public PontoDeParada(String nome, List<String> passageirosEmbarcados) {
		super();
		this.nome = nome;
		this.passageirosEmbarcados = new ArrayList<>();
	}
	
	public PontoDeParada(String nome) {
		super();
		this.nome = nome;
		this.passageirosEmbarcados = new ArrayList<>();
	}


	public void registrarEmbarqueComCartao(Passageiros passageiro, String cartao) {
        System.out.println("Passageiro " + passageiro.getNome() + " embarcou com o cartão " + passageiro.getTipoCartao() +
                " no ponto de parada " + this.nome);
        passageirosEmbarcados.add(passageiro.getNome() + "," + passageiro.getTipoCartao());
        // Lógica para registrar o embarque com cartão, se necessário.
    }
	 public void imprimirDadosPontoDeParada() {
	        for (String passageiro : passageirosEmbarcados) {
	            System.out.println("Passageiro embarcou: " + passageiro);
	        }
	    }
	
	 public void salvarDados() {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter("dadosPontoDeParada.txt", true))) {
	            for (String passageiro : passageirosEmbarcados) {
	                writer.write(passageiro);
	                writer.newLine();
	            }
	            System.out.println("Dados do ponto de parada salvos com sucesso.");
	        } catch (IOException e) {
	            System.out.println("Erro ao salvar dados do ponto de parada: " + e.getMessage());
	        }
	    }

	    public void carregarDados() {
	        try (BufferedReader reader = new BufferedReader(new FileReader("dadosPontoDeParada.txt"))) {
	            String linha;
	            while ((linha = reader.readLine()) != null) {
	                System.out.println("Passageiro embarcou: " + linha);
	            }
	            System.out.println("Dados do ponto de parada carregados com sucesso.");
	        } catch (IOException e) {
	            System.out.println("Erro ao carregar dados do ponto de parada: " + e.getMessage());
	        }
	    }
	


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	 
	 
	 
}
