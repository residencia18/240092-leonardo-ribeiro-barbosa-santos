package com.danielmonteiro.empresaAerea.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danielmonteiro.empresaAerea.model.Piloto;

public interface PilotoRepositorio extends JpaRepository<Piloto, Long> {

}
