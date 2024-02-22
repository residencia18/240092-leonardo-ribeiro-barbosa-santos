package EmpresaEletrica;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PagamentoTest {

    private Fatura fatura;

    @BeforeEach
    void setUp() {
        // Configurar uma fatura com data de emissão e fechamento válidas
        Imovel imovel1 = new Imovel();
        Date dataEmissao = new Date(System.currentTimeMillis() - 1000000); // Uma data de emissão anterior
        Date dataFechamento = new Date(); // Data de fechamento atual
        fatura = new Fatura(imovel1, dataEmissao);
        fatura.setDataFechamento(dataFechamento);
    }

    @Test
    void testRegistraPagamentoFaturaQuitada() {
        // Arrange
        fatura.setQuitada(true);
        Pagamento pagamento = new Pagamento(fatura, 50.0);

        // Act & Assert
        assertThrows(IllegalStateException.class, () -> {
            pagamento.registraPagamento(new Date());
        });
    }
    @Test
    void testRegistraPagamentoExcedeValorFatura() {
        // Arrange
        fatura.setValorCalculado(100.0);
        fatura.setValor(50.0);
        Pagamento pagamento = new Pagamento(fatura, 70.0);

        // Act & Assert
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            pagamento.registraPagamento(new Date());
        });
        System.out.println("Mensagem de exceção: " + exception.getMessage());
        assertTrue(exception.getMessage().contains("O valor pago excede o valor da fatura."));
    }






    @Test
    void testRegistraPagamentoSucesso() {
        // Arrange
        fatura.setValorCalculado(100.0);
        fatura.setValor(50.0);
        Pagamento pagamento = new Pagamento(fatura, 50.0);

        // Act
        pagamento.registraPagamento(new Date()); // Passando uma data válida

        // Assert
        assertTrue(fatura.isQuitada());
        assertEquals(100.0, fatura.getValorCalculado());
    }
}

