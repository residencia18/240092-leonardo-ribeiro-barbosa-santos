package com.danielmonteiro.empresaAerea.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danielmonteiro.empresaAerea.model.Aeroporto;

public interface AeroportoRepositorio extends JpaRepository<Aeroporto, Long>{

}
