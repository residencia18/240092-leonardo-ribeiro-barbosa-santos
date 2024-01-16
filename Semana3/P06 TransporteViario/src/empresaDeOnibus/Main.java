package empresaDeOnibus;



public class Main {
	public static void main(String[] args) {
		
		Jornada jornada = new Jornada();
		Trajetos trajeto = new Trajetos(1, "Ilhéus");
		Motoristas motorista = new Motoristas("Léo", 4336);
		Cobradores cobrador = new Cobradores("ju", 414);
		Veiculos veiculo = new 	Veiculos("Paradiso G8 1600 LD", "R1432\n\n");
		
		
		System.out.println("Cadastro de Motorista");
		jornada.cadastrarMotorista("Léo", 4336);
		
		System.out.println("\nCadastro de Cobrador");
		jornada.cadastrarCobrador("James", 414);
		
		System.out.println("\nCadastro do Veiculo");
		jornada.cadastrarVeiculo("Paradiso G8 1600 LD", "R1432\n\n");
		
		jornada.cadastrarTrajetos();
		
	
		jornada.registrarJornada(trajeto, motorista, cobrador, veiculo);
		
		
		
		
	}
}
