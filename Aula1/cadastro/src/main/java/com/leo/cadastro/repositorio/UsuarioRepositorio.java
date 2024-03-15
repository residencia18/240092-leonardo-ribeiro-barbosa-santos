package com.leo.cadastro.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leo.cadastro.model.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

}
