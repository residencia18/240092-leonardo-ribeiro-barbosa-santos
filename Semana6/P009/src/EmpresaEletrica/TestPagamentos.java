package EmpresaEletrica;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PagamentoTest {

    @Test
    void testRegistraPagamentoFaturaQuitada() {
        // Arrange
        Fatura fatura = new Fatura(null, null);
        fatura.setQuitada(true);
        Pagamento pagamento = new Pagamento(fatura, 50.0);

        // Act
        Exception exception = assertThrows(IllegalStateException.class, pagamento::registraPagamento);

        // Assert
        assertEquals("A fatura já está quitada. Não é possível registrar mais pagamentos.", exception.getMessage());
    }

    @Test
    void testRegistraPagamentoExcedeValorFatura() {
        // Arrange
        Fatura fatura = new Fatura(null, null);
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
        // Arrange
        Fatura fatura = new Fatura(null, null);
        fatura.setValorCalculado(100.0);
        fatura.setValor(50.0);
        Pagamento pagamento = new Pagamento(fatura, 50.0);

        // Act
        pagamento.registraPagamento();

        // Assert
        assertTrue(fatura.isQuitada());
        assertEquals(100.0, fatura.getValor());
    }
}


