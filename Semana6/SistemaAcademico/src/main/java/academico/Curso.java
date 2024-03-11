package academico;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Curso {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer Id;
	private String Nome;
	private Integer NumSemestre;
	
	@OneToMany(mappedBy = "cursos")
	List<Estudante> estudantes;
	
	
	
	
	public Curso(Integer id, String nome, Integer numSemestre) {
		Id = id;
		Nome = nome;
		NumSemestre = numSemestre;
	}




	public Curso() {
		super();
	}


	
	
	


	public Integer getId() {
		return Id;
	}




	public void setId(Integer id) {
		Id = id;
	}




	public String getNome() {
		return Nome;
	}




	public void setNome(String nome) {
		Nome = nome;
	}




	public Integer getNumSemestre() {
		return NumSemestre;
	}




	public void setNumSemestre(Integer numSemestre) {
		NumSemestre = numSemestre;
	}
	
	
	
	
	
	
}
