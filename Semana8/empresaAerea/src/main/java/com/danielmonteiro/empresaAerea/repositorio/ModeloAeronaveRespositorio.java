package com.danielmonteiro.empresaAerea.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danielmonteiro.empresaAerea.model.ModeloAeronave;

public interface ModeloAeronaveRespositorio extends JpaRepository<ModeloAeronave, Long>{

}
