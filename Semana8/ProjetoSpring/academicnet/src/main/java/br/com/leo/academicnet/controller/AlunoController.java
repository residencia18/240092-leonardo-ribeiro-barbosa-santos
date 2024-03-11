package br.com.leo.academicnet.controller;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.leo.academicnet.modelo.Aluno;
import br.com.leo.academicnet.repositorio.AlunoRepositorio;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	
	
	@Autowired
	private AlunoRepositorio alunoRepositorio;
	
	
	/*@GetMapping
	public Aluno getInfo() {
		
		Aluno aluno = new Aluno(1L,"José da Silva", "33334444","jose@feltx.com.br", Instant.now());
		return aluno;
	}
	*/
	
	@GetMapping
	public List<Aluno> listar() {
		return alunoRepositorio.findAll();
	}
	
	@PostMapping
	public void incluir(@RequestBody Aluno aluno) {
		 alunoRepositorio.save(aluno);
	}

	
	
	
}
