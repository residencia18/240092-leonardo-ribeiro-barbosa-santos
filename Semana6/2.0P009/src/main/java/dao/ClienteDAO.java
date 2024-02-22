package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import EmpresaEletrica.Cliente;

public class ClienteDAO {
		public static void main(String[] args) {



			try {
				
				Cliente cliente1 = new Cliente(null,"gamil", 18254234);
				Cliente cliente2 = new Cliente(null, "Tax", 804473433);
				
			

				EntityManagerFactory emf = Persistence.createEntityManagerFactory("academy");
				EntityManager em = emf.createEntityManager();

				em.getTransaction().begin();

				
				em.persist(cliente1);
				em.persist(cliente2);
				
			
			
				em.getTransaction().commit();

			
				em.close();
				emf.close();

				System.out.println("Objetos Cliente persistidos com sucesso.");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Erro ao conectar ou persistir objetos: " + e.getMessage());
			}
		}

}