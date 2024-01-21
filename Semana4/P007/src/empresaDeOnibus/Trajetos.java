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


public class Trajetos implements Persistencia{
	private String nomeTrajeto;
	private int idTrajeto;
	private ArrayList<Jornada> listaJornadas;
	private List<Veiculos> veiculos;
	private LocalDateTime inicio;
	private static List<Trajetos> listaTrajetos = new ArrayList<>();
	
	

	
	
	
	
	
	public Trajetos() {}
	  

	public Trajetos(String nomeTrajeto, int idTrajeto) {
		this.nomeTrajeto = nomeTrajeto;
		this.idTrajeto = idTrajeto;
		this.listaJornadas = new ArrayList<>();
	}






	public void salvarDados() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("dadosTrajetos.json"))) {
            JSONArray trajetosJSON = new JSONArray();
            for (Trajetos trajeto : listaTrajetos) {
                trajetosJSON.put(trajeto.toJSON());
            }

            writer.write(trajetosJSON.toString());
            System.out.println("Dados dos trajetos foram salvos no arquivo 'dadosTrajetos.json'.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados dos trajetos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void carregarDados() {
        try (BufferedReader reader = new BufferedReader(new FileReader("dadosTrajetos.json"))) {
            StringBuilder jsonContent = new StringBuilder();
            String linha;
            while ((linha = reader.readLine()) != null) {
                jsonContent.append(linha);
            }

            JSONArray trajetosJSON = new JSONArray(jsonContent.toString());

            for (int i = 0; i < trajetosJSON.length(); i++) {
                JSONObject trajetoJSON = trajetosJSON.getJSONObject(i);
                Trajetos trajeto = Trajetos.fromJSON(trajetoJSON);
                listaTrajetos.add(trajeto);
            }

            System.out.println("Dados dos trajetos carregados com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao carregar dados dos trajetos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private JSONObject toJSON() {
        JSONObject trajetoJSON = new JSONObject();
        trajetoJSON.put("nomeTrajeto", nomeTrajeto);
        trajetoJSON.put("idTrajeto", idTrajeto);
        return trajetoJSON;
    }

    private static Trajetos fromJSON(JSONObject trajetoJSON) {
        String nome = trajetoJSON.getString("nomeTrajeto");
        int id = trajetoJSON.getInt("idTrajeto");
        return new Trajetos(nome, id);
    }


	
	
	

	
	 
	 
	public void registrarTrechos() {}
	

	
	 public void registrarInicioTrajeto() {
	        if (listaJornadas != null && !listaJornadas.isEmpty()) {
	            Jornada jornada = listaJornadas.get(listaJornadas.size() - 1);  // Pega a última jornada adicionada
	            inicio = LocalDateTime.now();

	            // Define o formato brasileiro para o início do trajeto
	            DateTimeFormatter formatoInicioTrajeto = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	            String inicioFormatado = inicio.format(formatoInicioTrajeto);

	            System.out.println("Início do trajeto registrado para a Jornada ID " + jornada.getIdJornada() +
	                    " no trajeto " + nomeTrajeto + " às " + inicioFormatado);
	        } else {
	            System.out.println("Erro: Não há jornadas associadas a este trajeto ou listaJornadas é null.");
	        }
	    }
	 
	

	
	
	
	
	


	 public List<Jornada> getListaJornadas() {
	        return listaJornadas;
	    }

	public int getIdTrajeto() {
		return idTrajeto;
	}

	public void setIdTrajeto(int idTrajeto) {
		this.idTrajeto = idTrajeto;
	}

	public String getNomeTrajeto() {
		return nomeTrajeto;
	}

	public void setNomeTrajeto(String nomeTrajeto) {
		this.nomeTrajeto = nomeTrajeto;
	}

	

	public List<Veiculos> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculos> veiculos) {
		this.veiculos = veiculos;
	}



	public static List<Trajetos> getListaTrajetos() {
		return listaTrajetos;
	}



	public static void setListaTrajetos(List<Trajetos> listaTrajetos) {
		Trajetos.listaTrajetos = listaTrajetos;
	}
	
	
	

	 
	
}
