package empresaDeOnibus;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Trajetos {
	private String nomeTrajeto;
	private int idTrajeto;
	private ArrayList<Jornada> listaJornadas;
	private List<Veiculos> veiculos;
	private LocalDateTime inicio;
	
	
	
	
	


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






	
	
	

	
	
	

	
	public void registrarTrechos() {
		
		
	}
	
	public void registrarInicioTrajeto() {
	    if (listaJornadas != null && !listaJornadas.isEmpty()) {
	        Jornada jornada = listaJornadas.get(listaJornadas.size() - 1);  // Pega a última jornada adicionada
	        inicio = LocalDateTime.now();
	        System.out.println("Início do trajeto registrado para a Jornada ID " + jornada.getIdJornada() +
	                " no trajeto " + nomeTrajeto + " às " + inicio);
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
	
	
	

	 
	
}
