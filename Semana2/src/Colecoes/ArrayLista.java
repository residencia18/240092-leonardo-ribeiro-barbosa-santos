package Colecoes;

import java.util.ArrayList;

public class ArrayLista {
	ArrayList<String> lista;

	
	
	
	


	public ArrayLista() {
		this.lista = new ArrayList<String>();
	}



	public void  adicionarNome (String nome) {
		lista.add(nome);
		System.out.println( nome+ " Adicionado. Tamanho da lista:"  +  lista.size());
		
	}
	
	public boolean verificarNome(String nome) {
		for(String n: lista) {
		if(n != null && n.equals(nome))  {
			System.out.println("é igual " + nome);
			return true;
			}
		}
			return false;
		
	}
	
	
	public boolean modificarNome(String nome) throws ModificaException{
		System.out.println("Modificiou o nome: " + lista.get(0) );
		for(int i = 0; i < lista.size();i++) {
			
			lista.set(i, nome);
			System.out.println("Para o nome: "  + lista.get(i) );
		
			return true;
		
		}
		throw new ModificaException("Nome não existe na lista");
			
	}
	

	
public static void main(String[] args) throws ModificaException {

		
		ArrayLista a = new ArrayLista();
		
		
		a.adicionarNome("José");
		a.adicionarNome("leo");
		a.adicionarNome("Marcio");
		
		//pa
		a.verificarNome("leo");
		
		a.modificarNome("Vana");
		
	
		
		
		
		
		
		
	
		
		
		
	
		
		
		
		
		
		
		
		
	}
	

	
	
	
	
	
	
}