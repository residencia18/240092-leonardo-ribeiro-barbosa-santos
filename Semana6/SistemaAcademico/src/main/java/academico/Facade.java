package academico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Facade {
	
public static void main(String[] args) {
	 try {
		 
		 Curso curso = new Curso(null, "Historia", 8);
		 Estudante e1 = new Estudante(null,curso,"Tõe", "toe@tutu", "111111");
		 Estudante e2 = new Estudante(null,curso,"Lia", "lia@tutu", "222222");
		 Estudante e3 = new Estudante(null,curso,"tuca", "tuca@tutu", "3333333");
         Estudante e4 = new Estudante(null,curso,"tuca", "tuca@tutu", "3333333");
         
         EntityManagerFactory emf =
                 Persistence.createEntityManagerFactory("academy");
         EntityManager em = emf.createEntityManager();
         
         em.getTransaction().begin();
         em.persist(e1);
         em.persist(e2);
         em.persist(e3);
         em.persist(e4);
         em.persist(curso);
         em.getTransaction().commit();
         em.close();
         emf.close();
         
         System.out.println("Conexão estabelecida e objetos persistidos com sucesso.");
     } catch (Exception e) {
         e.printStackTrace();
         System.out.println("Erro ao conectar ou persistir objetos: " + e.getMessage());
     }
 }
}