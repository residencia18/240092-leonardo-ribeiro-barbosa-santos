package empresaDeOnibus;

import java.time.LocalDateTime;

public class Main {
	public static void main(String[] args) {
		
		Jornada jornada = new Jornada();
		System.out.println("Cadastro de Motorista");
		jornada.cadastrarMotorista("Léo", 436);
		
		System.out.println("\nCadastro de Cobrador");
		jornada.cadastrarCobrador("James", 414);
		
		System.out.println("\nCadastro do Veiculo");
		jornada.cadastrarVeiculo("Paradiso G8 1600 LD", "R1432");
		
		
		Trajetos trajeto = new Trajetos();
		trajeto.novaJornada(LocalDateTime.now(),LocalDateTime.now().plusHours(3));
	}
}
