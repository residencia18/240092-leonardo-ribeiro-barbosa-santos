
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		
		List<String> cidades = List.of("Itabuna", "Ilhéus", "Salvador", "Coaraci");
		
		DadosEstaticos cidadesDoBrasil = new CidadesDoBrasil(cidades);
		
		//conserta o codigo para trazer as cidade em ordem alfabéticas
		System.out.println("Cidade Ordem alfabética: "+ cidadesDoBrasil.maximo());
	}
	
}
