
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		
		List<String> cidades = List.of("Itabuna", "Ilhéus", "Salvador", "Coaraci");
		
		DadosEstaticos cidadesDoBrasil = new CidadesDoBrasil(cidades);
		
		
		System.out.println("Cidade com maior quantidade de letras: " + cidadesDoBrasil.maximo());
		
		System.out.println("Cidade com a menor quantidade de letras: " + cidadesDoBrasil.minimo());
		System.out.println("Cidade com a menor quantidade de letras: " + cidadesDoBrasil);
		cidadesDoBrasil.ordenar();
		System.out.println("Cidade com a menor quantidade de letras: " + cidadesDoBrasil);
		
		
		
	}
	
}
