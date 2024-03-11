package br.com.leonardo.empresaAerea.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.leonardo.empresaAerea.model.Aeroporto;

public interface AeroportoRepositorio extends JpaRepository<Aeroporto, Long>{

}
