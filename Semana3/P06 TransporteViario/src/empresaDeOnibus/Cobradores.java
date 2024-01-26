package empresaDeOnibus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Cobradores {
	private String nomeCobrador;
	private int cpfCobrador;
	
	
	
	

	
	

	 private static List<Cobradores> listaCobradores = new ArrayList<>();

	    public Cobradores() {
	    }

	    public Cobradores(String nomeCobrador, int cpfCobrador) {
	        this.nomeCobrador = nomeCobrador;
	        this.cpfCobrador = cpfCobrador;
	        // Adiciona a instância atual à lista
	        listaCobradores.add(this);
	    }

	    public static void salvarDados() {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter("dadosCobradores.txt"))) {
	            for (Cobradores cobrador : listaCobradores) {
	                writer.write(cobrador.nomeCobrador + "," + cobrador.cpfCobrador);
	                writer.newLine();
	            }
	            System.out.println("Dados dos cobradores salvos com sucesso.");
	        } catch (IOException e) {
	            System.out.println("Erro ao salvar dados dos cobradores: " + e.getMessage());
	        }
	    }

	    public static void carregarDados() {
	        try (BufferedReader reader = new BufferedReader(new FileReader("dadosCobradores.txt"))) {
	            String linha;
	            while ((linha = reader.readLine()) != null) {
	                String[] dados = linha.split(",");
	                Cobradores cobrador = new Cobradores(dados[0], Integer.parseInt(dados[1]));
	            }
	            System.out.println("Dados dos cobradores carregados com sucesso.");
	        } catch (IOException e) {
	            System.out.println("Erro ao carregar dados dos cobradores: " + e.getMessage());
	        }
	    }





	public int getCpfCobrador() {
		return cpfCobrador;
	}


	public void setCpfCobrador(int cpfCobrador) {
		this.cpfCobrador = cpfCobrador;
	}


	public String getNomeCobrador() {
		return nomeCobrador;
	}


	public void setNomeCobrador(String nomeCobrador) {
		this.nomeCobrador = nomeCobrador;
	}
	
	
}
