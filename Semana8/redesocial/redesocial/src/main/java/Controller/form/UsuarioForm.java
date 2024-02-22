package Controller.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.redesocial.redesocial.modelo.Usuario;
import com.redesocial.redesocial.repositorio.UsuarioRepositorio;

public class UsuarioForm {

	private String nome;
	private String senha;
	private String email;
	
	

	
	  @Autowired
	    private UsuarioRepositorio usuarioRepositorio;

	public UsuarioForm(String nome, String senha, String email) {
		this.nome = nome;
		this.senha = senha;
		this.email = email;
	}
	
	@PostMapping
	public Usuario criarUsuario() {
		Usuario usuario = new Usuario();
		
		nome = usuario.getNome();
		senha = usuario.getSenha();
		email = usuario.getEmail();	
		
		return usuario;
	}
	
	@PostMapping
	public void inserir(@RequestBody UsuarioForm usuarioForm) {
	
	    Usuario usuario = usuarioForm.toUsuario();
	    usuarioRepositorio.save(usuario);

	}

	
	
	
	private Usuario toUsuario() {
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setSenha(senha);
		usuario.setEmail(email);
		return usuario;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
