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
		// TODO Stub de método gerado automaticamente
		return null;
	}


	@Override
	public void ordenar() {
		// TODO Stub de método gerado automaticamente
		
	}


	@Override
	public boolean buscar() {
		// TODO Stub de método gerado automaticamente
		return false;
	}
	
	
	
}
