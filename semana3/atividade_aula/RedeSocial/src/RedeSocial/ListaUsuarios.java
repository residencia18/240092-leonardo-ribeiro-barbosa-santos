package RedeSocial;

import java.util.ArrayList;

public class ListaUsuarios {
	
	public ListaUsuarios(ArrayList<Usuario> listaDeUsuarios) {
		super();
		this.listaDeUsuarios = listaDeUsuarios;
	}
	
	public ListaUsuarios() {}
	
	private ArrayList<Usuario> listaDeUsuarios;	
	

	public ArrayList<Usuario> getListaDeUsuarios() {
		return listaDeUsuarios;
	}


	public void setListaDeUsuarios(ArrayList<Usuario> listaDeUsuarios) {
		this.listaDeUsuarios = listaDeUsuarios;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
	
