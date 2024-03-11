package dao;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import EmpresaEletrica.Cliente;
import EmpresaEletrica.Fatura;
import EmpresaEletrica.Imovel;
import EmpresaEletrica.Pagamento;
import EmpresaEletrica.Reembolso;

public class ReembolsoDAO {
	public static void main(String[] args) {
		try {
			
			
			Date data = new Date();
			
			
			
			Cliente novoCliente1 = new Cliente(null, "Jaque", 260099043);
			Imovel novoImovel1 = new Imovel("Centro Z, 566", 15, 20, novoCliente1);
			
			Fatura fatura1 = new Fatura(novoImovel1, data);
			Pagamento pag = new Pagamento(fatura1, 160);
			Reembolso reembolso1 = new Reembolso(pag);
			
			
		
			
		

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("academy");
			EntityManager em = emf.createEntityManager();

			em.getTransaction().begin();

			em.persist(novoCliente1);
			em.persist(novoImovel1);
			em.persist(fatura1);
			em.persist(pag);
			em.persist(reembolso1);
			
			
			fatura1.registrarLeitura(30);
			
			pag.registraPagamento();
			reembolso1.registrarReembolso();
		
			em.getTransaction().commit();
			
		
			em.close();
			emf.close();
			

			
			
			System.out.println("Objetos Pagamento persistidos com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao conectar ou persistir objetos: " + e.getMessage());
		}
	}
}


