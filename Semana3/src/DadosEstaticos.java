
public interface DadosEstaticos <T extends Comparable <T>> {

	T maximo();
	
	T minimo();
	
	void ordenar();
	
	boolean buscar(String valor);

	
}
