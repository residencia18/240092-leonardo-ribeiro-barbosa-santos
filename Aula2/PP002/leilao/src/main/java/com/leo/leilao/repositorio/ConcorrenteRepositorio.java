package com.leo.leilao.repositorio;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leo.leilao.modelo.Concorrente;

public interface ConcorrenteRepositorio extends JpaRepository<Concorrente, Long>{

	ArrayList<Concorrente> findByNome(String nome);

	ArrayList<Concorrente> findByCpf(String cpf);

	Concorrente getReferenceById(Long id);

}
