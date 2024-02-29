package br.com.prova.leilao.repository;


import java.util.ArrayList;


import org.springframework.data.jpa.repository.JpaRepository;



import br.com.prova.leilao.modelo.Leilao;

public interface LeilaoRepository extends JpaRepository<Leilao, Integer>{
	ArrayList<Leilao> findByDescricao(String descricao);

}
