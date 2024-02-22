package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import academico.Estudante;

public class TesteDAO {
	
	
	 public static void listarTodosEstudantes(EntityManager em) { 
		  String jpql = "selec e from Estudante e";
		  TypedQuery<Estudante> typedQuery = 
				  em.createQuery(jpql, Estudante.class);
		  List<Estudante> lista = typedQuery.getResultList();
		  for (Estudante e: lista) 
			  System.out.println(e);	 
	 
	 }
}
