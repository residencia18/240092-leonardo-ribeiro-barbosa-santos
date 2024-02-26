package br.com.leo.academicnet.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;


import br.com.leo.academicnet.modelo.Aluno;


public interface AlunoRepositorio extends JpaRepository<Aluno, Long> {

	

}
