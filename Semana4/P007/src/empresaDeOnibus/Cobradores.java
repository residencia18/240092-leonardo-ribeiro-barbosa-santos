package empresaDeOnibus;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Cobradores implements Persistencia {
	private String nomeCobrador;
	private int cpfCobrador;
	private static List<Cobradores> listaCobradores = new ArrayList<>();

	
	
	
	
	
	public Cobradores() {
	}

	public Cobradores(String nomeCobrador, int cpfCobrador) {
		this.nomeCobrador = nomeCobrador;
		this.cpfCobrador = cpfCobrador;
		listaCobradores.add(this);
	}

	
	
	
	
	
	public void salvarDados() {
		try (FileWriter fileWriter = new FileWriter("dadosCobradores.json")) {
			JSONArray cobradoresJSON = new JSONArray();
			for (Cobradores cobrador : listaCobradores) {
				cobradoresJSON.put(cobrador.toJSON());
			}

			fileWriter.write(cobradoresJSON.toString());
			System.out.println("Dados dos cobradores foram salvos no arquivo 'dadosCobradores.json'.");
		} catch (IOException e) {
			System.out.println("Erro ao salvar dados dos cobradores: " + e.getMessage());
			e.printStackTrace();
		}
	}


	public JSONObject toJSON() {
		JSONObject cobradoresJSON = new JSONObject();
		cobradoresJSON.put("nome", nomeCobrador);
		cobradoresJSON.put("cpf", cpfCobrador);
		return cobradoresJSON;
	}


	public void carregarDados() {
		try (BufferedReader reader = new BufferedReader(new FileReader("dadosCobradores.json"))) {
			StringBuilder jsonContent = new StringBuilder();
			String linha;
			while ((linha = reader.readLine()) != null) {
				jsonContent.append(linha);
			}

			JSONArray cobradoresJSON = new JSONArray(jsonContent.toString());

			for (int i = 0; i <cobradoresJSON.length(); i++) {
				JSONObject motoristaJSON = cobradoresJSON.getJSONObject(i);
				String nome = motoristaJSON.getString("nome");
				int cpf = motoristaJSON.getInt("cpf");
				Cobradores cobrador = new Cobradores(nome, cpf);
				listaCobradores.add(cobrador);
			}

			System.out.println("Dados dos cobradores carregados com sucesso.");
		} catch (IOException e) {
			System.out.println("Erro ao carregar dados dos cobradores: " + e.getMessage());
			e.printStackTrace();
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
