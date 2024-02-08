package academico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Facade {
	
public static void main(String[] args) {
	 try {
		 
		 Curso curso = new Curso(null, "Historia", 8);
		 Curso curso1 = new Curso(null, "Matematica", 7);
		 Curso curso2 = new Curso(null, "Geografia", 6);
		 
		 Estudante e1 = new Estudante(null,curso,"Tõe", "toe@tutu", "111111");
		 Estudante e2 = new Estudante(null,curso,"Lia", "lia@tutu", "222222");
		 Estudante e3 = new Estudante(null,curso,"tuca", "tuca@tutu", "3333333");
         Estudante e4 = new Estudante(null,curso2,"tairo", "tai@tutu", "4444444");
         Estudante e5 = new Estudante(null,curso1,"paco", "tpaco@tutu", "5555555");
         
      
         
         EntityManagerFactory emf =
                 Persistence.createEntityManagerFactory("academy");
         EntityManager em = emf.createEntityManager();
         
         em.getTransaction().begin();
         em.persist(e1);
         em.persist(e2);
         em.persist(e3);
         em.persist(e4);
         em.persist(e5);
         em.persist(curso);
         em.persist(curso1);
         em.persist(curso2);
         
         mostrarEstudantesPorCurso(em);
         listarTodosEstudantes(em);
         
         em.getTransaction().commit();
         em.close();
         emf.close();
         
         
         
         
        
         System.out.println("Conexão estabelecida e objetos persistidos com sucesso.");
     } catch (Exception e) {
         e.printStackTrace();
         System.out.println("Erro ao conectar ou persistir objetos: " + e.getMessage());
     }
	 
	 

	 
	 
	 
	 
	 
	 
	
	 

	 
	 
	 
	 

	 
	 
	 
	 
}



public static void listarTodosEstudantes(EntityManager em) { 
	  String jpql = "select e from Estudante e";
	  TypedQuery<Estudante> typedQuery = 
			  em.createQuery(jpql, Estudante.class);
	  List<Estudante> lista = typedQuery.getResultList();
	  for (Estudante e: lista) 
		  System.out.println(e);	
}

public static void alterarEstudante(EntityManager em ) {

	String jpql = "select e from Estudante e Where Id=1";
	TypedQuery<Estudante> typedQuery = 
			  em.createQuery(jpql, Estudante.class);
	Estudante e = typedQuery.getSingleResult();
	System.out.println(e);
	em.getTransaction().begin();
	e.setEmail("totonho@tut");
	em.persist(e);
	em.getTransaction().commit();
	  
}

	public static void listarnomesdosEstudantes(EntityManager em) {
		String jpql = "select e.nomes from Estudante e ";
		TypedQuery<String> typedQuery =
				em.createQuery(jpql, String.class);
		List<String>lista = typedQuery.getResultList();
		for (String e: lista)
			System.out.println(e);	
	
	}
	
	
	
	public static void gerarEstuanteDTO(EntityManager em) {
		String jpql = "select new dao.EstudanteDTO(e.Nome, "
		+ "e.Email, e.Matricula, e.Curso.Nome) from Estudante e";
		TypedQuery<EstudanteDTO> typedQuery =
		em.createQuery(jpql, EstudanteDTO.class);
		List<EstudanteDTO> lista = typedQuery.getResultList();
		for (EstudanteDTO e:lista)
		System.out.println(e);
		
		
	}
		
	public static void mostrarEstudantesPorCurso(EntityManager em) {
			String jpql = "select c from Curso c where c.Id = 1";
			TypedQuery<Curso> typedQuery =
			em.createQuery(jpql, Curso.class);
			Curso c = typedQuery.getSingleResult();
			String jpalEstudante = "select e from Estudante "
			+ "e where e.Curso = :curso";
			TypedQuery<Estudante> typedQueryEstudante =
			em.createQuery(jpalEstudante, Estudante.class);
			typedQueryEstudante.setParameter("curso", c);
			List<Estudante> lista = typedQueryEstudante.getResultList();
			for (Estudante e: lista)
			System.out.println(e);
}

}
