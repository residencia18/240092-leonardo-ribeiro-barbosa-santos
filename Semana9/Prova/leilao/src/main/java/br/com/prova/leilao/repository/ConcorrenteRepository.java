package br.com.prova.leilao.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcorrenteRepository extends JpaRepository<Concorrente, Integer>{
	ArrayList<Concorrente> findByDescricao(String descricao);
		
	
}
