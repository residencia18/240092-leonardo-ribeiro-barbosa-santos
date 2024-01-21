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


public class Trajetos {
	private String nomeTrajeto;
	private int idTrajeto;
	private ArrayList<Jornada> listaJornadas;
	private List<Veiculos> veiculos;
	private LocalDateTime inicio;
	
	
	  private static List<Trajetos> listaTrajetos = new ArrayList<>();
	
	


	public List<Jornada> getListaJornadas() {
        return listaJornadas;
    }
	   	
	
	
	public Trajetos() {
	}
	  





	public Trajetos(String nomeTrajeto, int idTrajeto) {
		this.nomeTrajeto = nomeTrajeto;
		this.idTrajeto = idTrajeto;
		this.listaJornadas = new ArrayList<>();
	}






	 public static void salvarDados() {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter("dadosTrajetos.txt"))) {
	            for (Trajetos trajeto : getListaTrajetos()) {
	                writer.write(trajeto.getNomeTrajeto() + "," + trajeto.getIdTrajeto());
	                writer.newLine();
	            }
	            System.out.println("Dados dos trajetos salvos com sucesso.");
	        } catch (IOException e) {
	            System.out.println("Erro ao salvar dados dos trajetos: " + e.getMessage());
	        }
	    }
	 public static void carregarDados() {
	        try (BufferedReader reader = new BufferedReader(new FileReader("dadosTrajetos.txt"))) {
	            String linha;
	            while ((linha = reader.readLine()) != null) {
	                String[] dados = linha.split(",");
	                if (dados.length >= 2) {
	                    Trajetos trajeto = new Trajetos(dados[0], Integer.parseInt(dados[1]));
	                    getListaTrajetos().add(trajeto);
	                } else {
	                    System.out.println("Linha mal formatada no arquivo de trajetos: " + linha);
	                }
	            }
	            System.out.println("Dados dos trajetos carregados com sucesso.");
	        } catch (IOException e) {
	            System.out.println("Erro ao carregar dados dos trajetos: " + e.getMessage());
	        }
	    }


	
	
	

	
	public void registrarTrechos() {
		
		
	}
	

	
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
