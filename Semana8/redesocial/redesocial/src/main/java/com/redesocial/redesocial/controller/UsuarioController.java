package com.redesocial.redesocial.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redesocial.redesocial.controller.dto.UsuarioDTO;
import com.redesocial.redesocial.modelo.Usuario;
import com.redesocial.redesocial.repositorio.UsuarioRepositorio;
@RequestMapping("/usuario/")
@RestController
public class UsuarioController {

    
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    	
     @GetMapping
     public List<UsuarioDTO> listaUsuarios(String nome){
		 System.out.println(nome);
    	 List<Usuario> listaUsuarios = (ArrayList<Usuario>) usuarioRepositorio.findByNome(nome);
    	 List<UsuarioDTO> lista = new ArrayList<UsuarioDTO>();
    	 for(Usuario usu: listaUsuarios) {
    		 UsuarioDTO usuDTO = new UsuarioDTO(usu);
    		 lista.add(usuDTO);
    		
    	 }
    	 
    	 return lista;
     }
    
}
