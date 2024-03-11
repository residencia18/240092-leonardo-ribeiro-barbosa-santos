import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CidadesDoBrasil implements DadosEstaticos<String> {
	
	
	
	
	
	
	public CidadesDoBrasil(String[] cidades) {
		super();
		this.cidades = Arrays.asList(cidades);
	}



	public List<String> getCidades() {
		return cidades;
	}



	public void setCidades(List<String> cidades) {
		this.cidades = cidades;
	}



	private List<String> cidades;
	
	
	
	
	public CidadesDoBrasil(ArrayList<String> cidades) {
		
		this.cidades = cidades;
	}

	

	
	
	


	@Override
	public String maximo() {
		
		return Collections.max(cidades);
	}


	@Override
	public String minimo() {
		
		 String menorCidade = cidades.get(0);
	        for (String cidade : cidades) {
	            if (cidade.length() < menorCidade.length()) {
	                menorCidade = cidade;
	            }
	        }
	        return menorCidade;

	}


	@Override
	public void ordenar() {
	
		 Collections.sort(cidades);
	}

	@Override
	public boolean buscar(String valor) {
		if(cidades.equals(cidades)) {
		return cidades.contains(valor);
		}
		else {
		return false;
		}
		
		
	}
	


	@Override
	public String toString() {
		return "CidadesDoBrasil [cidades=" + cidades + "]";
	}

	

	
	
	
	
}
