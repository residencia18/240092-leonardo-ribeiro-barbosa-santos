package RedeSocial;

import java.util.ArrayList;


public class Usuario {
	
	public Usuario(String nome, String email, String senha, ArrayList<String> listaDEPostagens) {
		super();
		this.nome = nome;
		Email = email;
		this.senha = senha;
		this.listaDEPostagens = listaDEPostagens;
	}
	public Usuario(String nome, String email) {
		super();
		this.nome = nome;
		Email = email;
	}
	
	public Usuario() {}
	
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
		return listaDEPostagens;
	}

	public void setListaDEPostagens(ArrayList<String> listaDEPostagens) {
		this.listaDEPostagens = listaDEPostagens;
	}
	
	public void novaPostagem(String postagem) {
		this.listaDEPostagens.add(postagem);
	}
	
	public void criarAmizade(Usuario amigo) {
		
	}
	
	public void destruirAizade(Usuario amigo) {
		
	}

	private String nome;
	private String Email;
	private String senha;
	private ArrayList<String> listaDEPostagens;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
