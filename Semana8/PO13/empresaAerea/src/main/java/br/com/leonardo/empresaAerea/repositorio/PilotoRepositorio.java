package br.com.leonardo.empresaAerea.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.leonardo.empresaAerea.model.Piloto;

public interface PilotoRepositorio extends JpaRepository<Piloto, Long> {

}
