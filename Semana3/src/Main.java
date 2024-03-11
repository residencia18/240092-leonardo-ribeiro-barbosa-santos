

public class Main {

	public static void main(String[] args) {
		
		
		String[] cidades = {"Salvador", "Itabuna", "Vitoria Da Conquista", "Ilheus", "Coaraci"};

		CidadesDoBrasil cidadeDoBrasil = new CidadesDoBrasil(cidades);
		
		//Cidades com o maior numero de letras
		System.out.println(cidadeDoBrasil.maximo());
		
		//Cidades com o menor numero de letras
		System.out.println(cidadeDoBrasil.minimo());
		
		
		System.out.println(cidadeDoBrasil.toString());
		
		cidadeDoBrasil.ordenar();
		
		System.out.println(cidadeDoBrasil.toString());
		
		
		System.out.println("busca: " + cidadeDoBrasil.buscar("Itabuna"));
		

	}
	
}