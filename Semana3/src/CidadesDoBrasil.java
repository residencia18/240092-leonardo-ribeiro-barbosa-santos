import java.util.Collections;
import java.util.List;

public class CidadesDoBrasil implements DadosEstaticos{
	
	private List<String> cidades;
	
	
	
	
	public CidadesDoBrasil(List<String> cidades) {
		
		this.cidades = cidades;
	}

	
	public List<String> getCidades() {
		return cidades;
	}
	public void setCidades(List<String> cidades) {
		this.cidades = cidades;
	}


	@Override
	public Object maximo() {
		
		return Collections.max(cidades);
	}


	@Override
	public Object minimo() {
		return Collections.min(cidades);
	}


	@Override
	public void ordenar() {
		Collections.sort(cidades);
		
	}


	@Override
	public boolean buscar(Object valor) {
		if (valor instanceof String) {
			String stringValue = (String) valor;
	        return cidades.contains(stringValue);
	    }
		return false;
	}
	
	
	
}
