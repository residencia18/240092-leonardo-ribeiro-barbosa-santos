package empresaDeOnibus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class CheckPoints {
	private LocalDateTime horarioChegada;
	 private String nomeCheckpoint;
	 private String tipoCheckpoint;
	 private static List<CheckPoints> listaCheckPoints = new ArrayList<>();

	
	
	

	public CheckPoints() {
	}
	
	
	public CheckPoints(String nomeCheckpoint, String tipoCheckpoint) {
		this.nomeCheckpoint = nomeCheckpoint;
		this.tipoCheckpoint = tipoCheckpoint;
		listaCheckPoints.add(this);
	}

	public void salvarDados() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("dadosCheckPoints.json"))) {
            JSONArray checkpointsJSON = new JSONArray();
            for (CheckPoints checkpoint : listaCheckPoints) {
                checkpointsJSON.put(checkpoint.toJSON());
            }

            writer.write(checkpointsJSON.toString());
            System.out.println("Dados dos checkpoints foram salvos no arquivo 'dadosCheckPoints.json'.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados dos checkpoints: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void carregarDados() {
        try (BufferedReader reader = new BufferedReader(new FileReader("dadosCheckPoints.json"))) {
            StringBuilder jsonContent = new StringBuilder();
            String linha;
            while ((linha = reader.readLine()) != null) {
                jsonContent.append(linha);
            }

            JSONArray checkpointsJSON = new JSONArray(jsonContent.toString());

            for (int i = 0; i < checkpointsJSON.length(); i++) {
                JSONObject checkpointJSON = checkpointsJSON.getJSONObject(i);
                CheckPoints checkpoint = CheckPoints.fromJSON(checkpointJSON);
                listaCheckPoints.add(checkpoint);
            }

            System.out.println("Dados dos checkpoints carregados com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao carregar dados dos checkpoints: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private JSONObject toJSON() {
        JSONObject checkpointJSON = new JSONObject();
        checkpointJSON.put("nomeCheckpoint", nomeCheckpoint);
        checkpointJSON.put("tipoCheckpoint", tipoCheckpoint);
        return checkpointJSON;
    }

    private static CheckPoints fromJSON(JSONObject checkpointJSON) {
        String nomeCheckpoint = checkpointJSON.getString("nomeCheckpoint");
        String tipoCheckpoint = checkpointJSON.getString("tipoCheckpoint");
        return new CheckPoints(nomeCheckpoint, tipoCheckpoint);
    }

    
    
	public void registrarChegada() {
        this.horarioChegada = LocalDateTime.now();

        DateTimeFormatter formatoCheckpoint = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String chegadaFormatada = horarioChegada.format(formatoCheckpoint);

        System.out.println("Veículo chegou ao checkpoint "  + " às " + chegadaFormatada);
    }
}
	 

