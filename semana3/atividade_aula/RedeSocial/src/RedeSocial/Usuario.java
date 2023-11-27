package RedeSocial;

import java.util.ArrayList;


public class Usuario {
	
	public Usuario(String nome, String email, String senha, ArrayList<String> listaDePostagens) {
		super();
		this.nome = nome;
		Email = email;
		this.senha = senha;
		this.listaDePostagens = listaDePostagens;
	}
	public Usuario(String nome, String email) {
		super();
		this.nome = nome;
		Email = email;
	}

	private String nome;
	private String Email;
	private String senha;
	private ArrayList<String> listaDePostagens;
	private ArrayList<Usuario> listaDeAmigos;
	
	
	
	public Usuario() {}
	
	public void setAmizade(Usuario user) {
		this.listaDeAmigos.add(user);
	}

	public ArrayList<Usuario>  getListaAmizade() {
		return this.listaDeAmigos;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return Email;
	}	

	public void setEmail(String email) {
		Email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public ArrayList<String> getListaDEPostagens() {
		return listaDePostagens;
	}

	public void setListaDePostagens(ArrayList<String> listaDePostagens) {
		this.listaDePostagens = listaDePostagens;
	}
	
	public void setPostagem(String postagem) {
		this.listaDePostagens.add(postagem);
	}
	
	public void novaPostagem(String postagem) {
		this.listaDePostagens.add(postagem);
	}
	
	public void criarAmizade(Usuario amigo) {
		setAmizade(amigo);
	}
	
	public Boolean destruirAizade(Usuario amigo) {
		for (int i = 0; i < getListaAmizade().size(); i++) {
			
			if(amigo.equals(getListaAmizade().get(i))){
				getListaAmizade().remove(i);
				return true;
			}
		}
		return false;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
