package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import EmpresaEletrica.Cliente;
import EmpresaEletrica.Imovel;

public class ImovelDAO {
	
public static void main(String[] args) {
	try {
		
		Cliente cliente1 = new Cliente(null,"Hebert", 84554234);
		Cliente cliente2 = new Cliente(null,"Lucas", 16440234);
		
		
		Imovel imovel1 = new Imovel("Rua A, 154", cliente1);
		Imovel imovel2 = new Imovel("Rua b, 154", cliente2);
		
	

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("academy");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		
		em.persist(imovel1);
		em.persist(imovel2);
		
		
		
	
	
		em.getTransaction().commit();
		
	
		em.close();
		emf.close();
		

		
		
		System.out.println("Objetos Imovel persistidos com sucesso.");
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("Erro ao conectar ou persistir objetos: " + e.getMessage());
	}
}
}

