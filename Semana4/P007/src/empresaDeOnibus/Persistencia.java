package empresaDeOnibus;


import org.json.JSONArray;

import java.io.*;

public interface Persistencia {

	void salvarDados();

	void carregarDados();

	default void salvarJSONArray(JSONArray jsonArray, String fileName) {
		try (FileWriter fileWriter = new FileWriter(fileName)) {
			fileWriter.write(jsonArray.toString());
			System.out.println("Dados salvos com sucesso no arquivo '" + fileName + "'.");
		} catch (IOException e) {
			System.out.println("Erro ao salvar dados: " + e.getMessage());
		}
	}

	default JSONArray carregarJSONArray(String fileName) {
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			StringBuilder jsonContent = new StringBuilder();
			String linha;
			while ((linha = reader.readLine()) != null) {
				jsonContent.append(linha);
			}
			return new JSONArray(jsonContent.toString());
		} catch (IOException e) {
			System.out.println("Erro ao carregar dados: " + e.getMessage());
			return new JSONArray();
		}
	}
}


