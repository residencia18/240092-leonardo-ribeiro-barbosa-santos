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
		
		jornada.cadastrarTrajetos("Ilheus", 2);
		
	
		jornada.registrarJornada();
		
		Trajetos trajeto = new Trajetos();
		Passageiros passageiros = new Passageiros("José", "434FDS");
		
		
		PontoDeParada ponto = new PontoDeParada("Rodoviaria");
		ponto.registrarEmbarqueComCartao(passageiros, "" );
		
		
		CheckPoints check = new CheckPoints();
		check.registrarChegada();
		Motoristas m = new Motoristas();
		m.salvarDados();
		m.carregarDados();

		Cobradores c = new Cobradores();
		c.salvarDados();
		c.carregarDados();
		
		veiculos.salvarDados();
		veiculos.carregarDados();
		
		
		trajeto.salvarDados();
		trajeto.carregarDados();
		
		check.salvarDados();
		check.carregarDados();
		
		ponto.salvarDados();
		ponto.carregarDados();
		
	}
}
