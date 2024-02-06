package academico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Facade {
	
public static void main(String[] args) {
	 try {
         Estudante e1 = new Estudante(null, "Tõe", "toe@tutu", "111111");
         Estudante e2 = new Estudante(null, "Lia", "lia@tutu", "222222");
         Estudante e3 = new Estudante(null, "tuca", "tuca@tutu", "3333333");
         
         EntityManagerFactory emf =
                 Persistence.createEntityManagerFactory("academy");
         EntityManager em = emf.createEntityManager();
         
         em.getTransaction().begin();
         em.persist(e1);
         em.persist(e2);
         em.persist(e3);
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