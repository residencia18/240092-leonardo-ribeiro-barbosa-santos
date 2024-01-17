package empresaDeOnibus;

import java.time.LocalDateTime;

public class CheckPoints {
	private LocalDateTime horarioChegada;

	
	
	

	public CheckPoints() {
	}



	public void registrarChegada() {
		this.horarioChegada = LocalDateTime.now();
		System.out.println("Veículo chegou ao checkpoint "  + " às " + horarioChegada);
		horarioChegada = LocalDateTime.now();
	}
}
