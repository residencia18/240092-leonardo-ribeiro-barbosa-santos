package dao;



import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import EmpresaEletrica.Cliente;
import EmpresaEletrica.Fatura;
import EmpresaEletrica.Imovel;

public class FaturaDAO {
	public static void main(String[] args) {
		try {
			
			
			Date data = new Date();
			
			
			
			Cliente novoCliente1 = new Cliente(null, "Juca", 790914313);
			Imovel novoImovel1 = new Imovel("Centro, 576", 15, 20, novoCliente1);
			
			Fatura fatura1 = new Fatura(novoImovel1, data);
			
			
		;
			
			
			
			
			
		

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("academy");
			EntityManager em = emf.createEntityManager();

			em.getTransaction().begin();

			em.persist(novoCliente1);
			em.persist(novoImovel1);
			em.persist(fatura1);
			
			
			fatura1.registrarLeitura(30);
			
		
		
			em.getTransaction().commit();
			
		
			em.close();
			emf.close();
			

			
			
			System.out.println("Objetos Fatura persistidos com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao conectar ou persistir objetos: " + e.getMessage());
		}
	}
}
