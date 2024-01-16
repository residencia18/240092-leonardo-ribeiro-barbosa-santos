package empresaDeOnibus;


import java.util.ArrayList;
import java.util.List;


public class Trajetos {

	private int idTrajeto;
	private String nomeTrajeto;
	private ArrayList<Jornada> listaJornadas;
	private List<Veiculos> veiculos;
	
	
	public Trajetos() {
        this.veiculos = new ArrayList<>();
    }
	
	
	
	public Trajetos(int idTrajeto, String nomeTrajeto) {
		super();
		this.idTrajeto = idTrajeto;
		this.nomeTrajeto = nomeTrajeto;
	}



	public Trajetos(int idTrajeto, String nomeTrajeto, ArrayList<Jornada> listaJornadas, List<Veiculos> veiculos) {
		this.idTrajeto = idTrajeto;
		this.nomeTrajeto = nomeTrajeto;
		this.listaJornadas = listaJornadas;
		this.veiculos = veiculos;
	}




	   	
	
	
	public void registrarVeiculos(Veiculos veiculo) {
	
	}
	
	public void registrarJornada() {
		
	}
	
	
	

	
	public void registrarTrechos() {
		
	}
	
	public void iniciarNovoTrajeto() {
		
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
