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


public class Veiculos {

	private String placa;
	private String modelo;
	private static List<Veiculos> listaVeiculos = new ArrayList<>();

	
	
	
	
	public Veiculos() {
	}

	public Veiculos(String placa, String modelo) {
		this.placa = placa;
		this.modelo = modelo;
		listaVeiculos.add(this);
	}
	
	
	
	

	public void salvarDados() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("dadosVeiculos.json"))) {
			JSONArray veiculosJSON = new JSONArray();
			for (Veiculos veiculo : listaVeiculos) {
				veiculosJSON.put(veiculo.toJSON());
			}

			writer.write(veiculosJSON.toString());
			System.out.println("Dados dos veículos foram salvos no arquivo 'dadosVeiculos.json'.");
		} catch (IOException e) {
			System.out.println("Erro ao salvar dados dos veículos: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	public JSONObject toJSON() {
		JSONObject veiculoJSON = new JSONObject();
		veiculoJSON.put("modelo", modelo);
		veiculoJSON.put("placa", placa);
		return veiculoJSON;
	}

	
	
	public void carregarDados() {
		try (BufferedReader reader = new BufferedReader(new FileReader("dadosVeiculos.json"))) {
			StringBuilder jsonContent = new StringBuilder();
			String linha;
			while ((linha = reader.readLine()) != null) {
				jsonContent.append(linha);
			}

			JSONArray veiculosJSON = new JSONArray(jsonContent.toString());

			for (int i = 0; i < veiculosJSON.length(); i++) {
				JSONObject veiculoJSON = veiculosJSON.getJSONObject(i);
				String modelo = veiculoJSON.getString("modelo");
				String placa = veiculoJSON.getString("placa");
				Veiculos veiculo = new Veiculos(modelo, placa);
				listaVeiculos.add(veiculo);
			}

			System.out.println("Dados dos veículos carregados com sucesso.");
		} catch (IOException e) {
			System.out.println("Erro ao carregar dados dos veículos: " + e.getMessage());
			e.printStackTrace();
		}
	}



	
	
	
	
	public String getModelo() {
		return modelo;
	}



	public void setModelo(String modelo) {
		this.modelo = modelo;
	}




	public String getPlaca() {
		return placa;
	}



	public void setPlaca(String placa) {
		this.placa = placa;
	}

	@Override
	public String toString() {
		return "Veículo: " + modelo + " (Placa: " + placa + ")";
	}


}
