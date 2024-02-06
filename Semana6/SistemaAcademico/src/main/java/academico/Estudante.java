package academico;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
public class Estudante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	private String Nome;
	private String Email;
	private String Matricula;
	
	
	public Estudante(Integer id, String nome, String email, String matricula) {
	
		Id = null;
		Nome = nome;
		Email = email;
		Matricula = matricula;
	}
	



	public Estudante() {
	
	}


	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public String getNome() {
		return Nome;
	}


	public void setNome(String nome) {
		Nome = nome;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public String getMatricula() {
		return Matricula;
	}


	public void setMatricula(String matricula) {
		Matricula = matricula;
	}


	@Override
	public String toString() {
		return "Estudante [Id=" + Id + ", Nome=" + Nome + ", Email=" + Email + ", Matricula=" + Matricula + "]";
	}
	
	
	
	
}
