package EmpresaEletrica;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

class PagamentoTest {

	  @Test
	    void testRegistraPagamentoFaturaQuitada() {
	    	Imovel imovel1 = new Imovel();
	    	Date data = new Date();
	        // Arrange
	        Fatura fatura = new Fatura(imovel1, data);
	        fatura.setQuitada(true);
	        Pagamento pagamento = new Pagamento(fatura, 50.0);

	        // Act
	        Exception exception = assertThrows(IllegalStateException.class, pagamento::registraPagamento);

	        // Assert
	        assertEquals("A fatura já está quitada. Não é possível registrar mais pagamentos.", exception.getMessage());
	    }

	    @Test
	    void testRegistraPagamentoExcedeValorFatura() {
	    	Imovel imovel1 = new Imovel();
	    	Date data = new Date();
	        // Arrange
	        Fatura fatura = new Fatura(imovel1, data);
	        fatura.setValorCalculado(100.0);
	        fatura.setValor(50.0);
	        Pagamento pagamento = new Pagamento(fatura, 70.0);

	        // Act
	        Exception exception = assertThrows(IllegalStateException.class, pagamento::registraPagamento);

	        // Assert
	        assertEquals("Erro: O valor pago excede o valor da fatura de 100.0", exception.getMessage());
	    }

	    @Test
		    void testRegistraPagamentoSucesso() {
		    	Imovel imovel1 = new Imovel();
		    	Date data = new Date();
		        // Arrange
		        Fatura fatura = new Fatura(imovel1, data);
		        fatura.setValorCalculado(100.0);
		        fatura.setValor(50.0);
		        Pagamento pagamento = new Pagamento(fatura, 50.0);
	
		        // Act
		        pagamento.registraPagamento();
	
		        // Assert
		        assertTrue(fatura.isQuitada());
		        assertEquals(100.0, fatura.getValorCalculado());
		    }
		}



