package academico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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