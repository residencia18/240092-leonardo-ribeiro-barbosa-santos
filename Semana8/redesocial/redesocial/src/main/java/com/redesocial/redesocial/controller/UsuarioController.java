package com.redesocial.redesocial.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redesocial.redesocial.controller.dto.UsuarioDTO;
import com.redesocial.redesocial.modelo.Usuario;
import com.redesocial.redesocial.repositorio.UsuarioRepositorio;
@RequestMapping("/usuario/")
@RestController
public class UsuarioController {

	private String nome;
	private String senha;
	private String email;






	@Autowired
    private UsuarioRepositorio usuarioRepositorio;
    
    /*
    @GetMapping
    public List<UsuarioDTO> listaUsuarios( String nome) {
        List<Usuario> listaUsuarios;
        
        if (nome != null && !nome.isEmpty()) {
            listaUsuarios = usuarioRepositorio.findByNome(nome);
        } else {
            listaUsuarios = usuarioRepositorio.findAll();
        }
        
        List<UsuarioDTO> lista = new ArrayList<>();
        for(Usuario usu: listaUsuarios) {
            UsuarioDTO usuDTO = new UsuarioDTO(usu);
            lista.add(usuDTO);
        }
        
        return lista;
    }
    */
    
    @GetMapping
	public List<Usuario> criarUsuario() {
		return usuarioRepositorio.findAll();
	}
	
	@PostMapping
	public void inserir(@RequestBody Usuario usuario) {

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
