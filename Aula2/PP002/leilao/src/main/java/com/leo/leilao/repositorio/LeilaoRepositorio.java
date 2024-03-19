package com.leo.leilao.repositorio;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leo.leilao.modelo.Leilao;

public interface LeilaoRepositorio extends JpaRepository<Leilao, Long> {

	ArrayList<Leilao> findByDescricao(String descricao);

	ArrayList<Leilao> findByStatus(String status);

	ArrayList<Leilao> findByValorMinimo(double valorMinimo);

	Leilao getReferenceById(Long id);

}
