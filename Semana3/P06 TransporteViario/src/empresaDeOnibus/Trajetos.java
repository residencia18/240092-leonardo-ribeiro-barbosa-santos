package empresaDeOnibus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Trajetos {

	private int idTrajeto;
	private String nomeTrajeto;
	private ArrayList<Jornada> listaJornadas;
	private List<Veiculos> veiculos;
	private List<Trajetos> trajetos;
	
	
	public Trajetos() {
        this.veiculos = new ArrayList<>();
    }
	
	
	public void novaJornada() {
	      
	    }

	   	
	
	
	public void registrarVeiculos(Veiculos veiculo) {
	
	}
	
	public void registrarJornada() {
		
	}
	
	
	public void cadastrarTrajetos() {
		
	}
	
	public void registrarTrechos() {
		
	}
	
	public void iniciarNovoTrajeto() {
		
	}
	
	
	
	
	

	public ArrayList<Jornada> getListaJornadas() {
		return listaJornadas;
	}


	public void setListaJornadas(ArrayList<Jornada> listaJornadas) {
		this.listaJornadas = listaJornadas;
	}


	public List<Trajetos> getTrajetos() {
		return trajetos;
	}


	public void setTrajetos(List<Trajetos> trajetos) {
		this.trajetos = trajetos;
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
