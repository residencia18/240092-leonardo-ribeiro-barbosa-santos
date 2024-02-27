package com.redesocial.redesocial.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

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
	
    
    //Conserta esse metodo
    @PostMapping
    public ResponseEntity<UsuarioDTO> inserir(UriComponentsBuilder uriBuilder) {
        // Cria um novo usuário com um ID gerado automaticamente
        Usuario usuario = new Usuario();
        usuarioRepositorio.save(usuario);
        
        // Cria um DTO para o novo usuário
        UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
        
        // Monta a URI para o novo usuário
        URI uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();
        
        // Retorna a resposta com o DTO do usuário criado e o código de status 201 (Created)
        return ResponseEntity.created(uri).body(usuarioDTO);
    }

	
	
	

	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDTO> listaUsuarios(@PathVariable Integer id , UriComponentsBuilder uriBuilder) {
	try {
		Usuario usuario = usuarioRepositorio.getReferenceById(id);
		UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
		uriBuilder.path("/usuario/{id}");
		return ResponseEntity.ok(usuarioDTO);
	}	catch (Exception e ) {
		return ResponseEntity.notFound().build();
	}
	}


	// Importe outras classes necessárias

	@PutMapping("/{id}")
	public ResponseEntity<?> alteraUsuario(@PathVariable Integer id, @RequestBody Usuario usuarioAtualizado) {
	    try {
	        java.util.Optional<Usuario> optionalUsuario = usuarioRepositorio.findById(id);
	        
	        if (optionalUsuario.isPresent()) {
	            Usuario usuario = optionalUsuario.get();
	            usuario.setNome(usuarioAtualizado.getNome());
	            usuario.setEmail(usuarioAtualizado.getEmail());
	            usuario.setSenha(usuarioAtualizado.getSenha());
	            usuarioRepositorio.save(usuario);
	            
	            UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
	            return ResponseEntity.ok(usuarioDTO);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletaUsuario(@PathVariable Integer id) {
	    try {
	        java.util.Optional<Usuario> optionalUsuario = usuarioRepositorio.findById(id);
	        
	        if (optionalUsuario.isPresent()) {
	            Usuario usuario = optionalUsuario.get();
	         
	            usuarioRepositorio.delete(usuario);
	            
	           
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
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
