package empresaDeOnibus;



public class Main {
	public static void main(String[] args) {
		
		Jornada jornada = new Jornada();
		Veiculos veiculos = new Veiculos();
		
		
		System.out.println("Cadastro de Motorista");
		jornada.cadastrarMotorista("Léo", 4336);
		
		System.out.println("\nCadastro de Cobrador");
		jornada.cadastrarCobrador("James", 414);
		
		System.out.println("\nCadastro do Veiculo");
		jornada.cadastrarVeiculo("Paradiso G8 1600 LD", "R1432\n\n");
		
		jornada.cadastrarTrajetos("Ilheus", 0);
		
	
		jornada.registrarJornada();
		
		Trajetos trajeto = new Trajetos();
		
		
		
		
		
	}
}
