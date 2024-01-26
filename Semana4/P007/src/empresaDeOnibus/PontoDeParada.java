package empresaDeOnibus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class PontoDeParada {
	private String nome;
	private List<String> passageirosEmbarcados;
	private static List<PontoDeParada> listaPontos = new ArrayList<>();
	
	

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
    }
	
	 public void imprimirDadosPontoDeParada() {
	        for (String passageiro : passageirosEmbarcados) {
	            System.out.println("Passageiro embarcou: " + passageiro);
	        }
	    }
	  public void salvarDados() {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter("dadosPontosDeParada.json"))) {
	            JSONArray pontosJSON = new JSONArray();
	            for (PontoDeParada ponto : listaPontos) {
	                pontosJSON.put(ponto.toJSON());
	            }

	            writer.write(pontosJSON.toString());
	            System.out.println("Dados dos pontos de parada foram salvos no arquivo 'dadosPontosDeParada.json'.");
	        } catch (IOException e) {
	            System.out.println("Erro ao salvar dados dos pontos de parada: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }

	    public void carregarDados() {
	        try (BufferedReader reader = new BufferedReader(new FileReader("dadosPontosDeParada.json"))) {
	            StringBuilder jsonContent = new StringBuilder();
	            String linha;
	            while ((linha = reader.readLine()) != null) {
	                jsonContent.append(linha);
	            }

	            JSONArray pontosJSON = new JSONArray(jsonContent.toString());

	            for (int i = 0; i < pontosJSON.length(); i++) {
	                JSONObject pontoJSON = pontosJSON.getJSONObject(i);
	                PontoDeParada ponto = PontoDeParada.fromJSON(pontoJSON);
	                listaPontos.add(ponto);
	            }

	            System.out.println("Dados dos pontos de parada carregados com sucesso.");
	        } catch (IOException e) {
	            System.out.println("Erro ao carregar dados dos pontos de parada: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }

	    private JSONObject toJSON() {
	        JSONObject pontoJSON = new JSONObject();
	        pontoJSON.put("nomePonto", nome);
	        // Adicionar outros atributos ao JSON conforme necessário
	        return pontoJSON;
	    }

	    private static PontoDeParada fromJSON(JSONObject pontoJSON) {
	        String nomePonto = pontoJSON.getString("nomePonto");
	        // Recuperar outros atributos do JSON conforme necessário
	        return new PontoDeParada(nomePonto);
	    }
	
	


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	 
	 
	 
}
