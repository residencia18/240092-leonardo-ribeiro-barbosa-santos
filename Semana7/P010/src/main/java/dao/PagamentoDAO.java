package dao;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import EmpresaEletrica.Cliente;
import EmpresaEletrica.Fatura;
import EmpresaEletrica.Imovel;
import EmpresaEletrica.Pagamento;

public class PagamentoDAO {
	public static void main(String[] args) {
		try {
			
			
			Date data = new Date();
			
			Date DataFechameto = new Date(12);
			
			Cliente novoCliente1 = new Cliente(null, "Zelia", 960114343);
			Imovel novoImovel1 = new Imovel("Centro B, 566", novoCliente1);
			
			Fatura fatura1 = new Fatura(novoImovel1, data);
			Pagamento pag = new Pagamento(fatura1, 100);
			
			
		;
			
			
			
			
			
		

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("academy");
			EntityManager em = emf.createEntityManager();

			em.getTransaction().begin();

			em.persist(novoCliente1);
			em.persist(novoImovel1);
			em.persist(fatura1);
			em.persist(pag);
			
			
			fatura1.registrarLeitura(30, DataFechameto);
			
			pag.registraPagamento(DataFechameto);
		
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
