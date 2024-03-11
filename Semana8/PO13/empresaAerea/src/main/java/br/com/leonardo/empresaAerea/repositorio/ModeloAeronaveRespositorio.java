package br.com.leonardo.empresaAerea.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.leonardo.empresaAerea.model.ModeloAeronave;

public interface ModeloAeronaveRespositorio extends JpaRepository<ModeloAeronave, Long>{

}
