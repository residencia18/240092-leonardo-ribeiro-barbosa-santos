package empresaDeOnibus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;




public class Motoristas implements Persistencia {



	private String nomeMotorista;
	private int cpfMotorista;
	private static List<Motoristas> listaMotoristas = new ArrayList<>();

	public Motoristas() {
	}

	public Motoristas(String nomeMotorista, int cpfMotorista) {
		this.nomeMotorista = nomeMotorista;
		this.cpfMotorista = cpfMotorista;
		// Adiciona a instância atual à lista
		listaMotoristas.add(this);
	}

	public void salvarDados() {
		try (FileWriter fileWriter = new FileWriter("dadosMotoristas.json")) {
			JSONArray motoristasJSON = new JSONArray();
			for (Motoristas motorista : listaMotoristas) {
				motoristasJSON.put(motorista.toJSON());
			}

			fileWriter.write(motoristasJSON.toString());
			System.out.println("Dados dos motoristas foram salvos no arquivo 'dadosMotoristas.json'.");
		} catch (IOException e) {
			System.out.println("Erro ao salvar dados dos motoristas: " + e.getMessage());
			e.printStackTrace();
		}
	}


	public JSONObject toJSON() {
		JSONObject motoristaJSON = new JSONObject();
		motoristaJSON.put("nome", nomeMotorista);
		motoristaJSON.put("cpf", cpfMotorista);
		return motoristaJSON;
	}


	public void carregarDados() {
		try (BufferedReader reader = new BufferedReader(new FileReader("dadosMotoristas.json"))) {
			StringBuilder jsonContent = new StringBuilder();
			String linha;
			while ((linha = reader.readLine()) != null) {
				jsonContent.append(linha);
			}

			JSONArray motoristasJSON = new JSONArray(jsonContent.toString());

			for (int i = 0; i < motoristasJSON.length(); i++) {
				JSONObject motoristaJSON = motoristasJSON.getJSONObject(i);
				String nome = motoristaJSON.getString("nome");
				int cpf = motoristaJSON.getInt("cpf");
				Motoristas motorista = new Motoristas(nome, cpf);
				listaMotoristas.add(motorista);
			}

			System.out.println("Dados dos motoristas carregados com sucesso.");
		} catch (IOException e) {
			System.out.println("Erro ao carregar dados dos motoristas: " + e.getMessage());
			e.printStackTrace();
		}
	}



	public static List<Motoristas> getListaMotoristas() {
		return listaMotoristas;
	}

	public static void setListaMotoristas(List<Motoristas> listaMotoristas) {
		Motoristas.listaMotoristas = listaMotoristas;
	}



	public int getCpfMotorista() {
		return cpfMotorista;
	}



	public void setCpfMotorista(int cpfMotorista) {
		this.cpfMotorista = cpfMotorista;
	}



	public String getNomeMotorista() {
		return nomeMotorista;
	}



	public void setNomeMotorista(String nomeMotorista) {
		this.nomeMotorista = nomeMotorista;
	}
}