package EmpresaEletrica;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

class TestPagamentos {

	@Test
	void testRegistraPagamentoQuitada() {
	    Date data = new Date();
	    Cliente cliente = new Cliente("jose", 32);
	    Imovel imovel = new Imovel(12, "rua", cliente);
	    Fatura novafatura = new Fatura(imovel, 20, 10, data);

	    novafatura.registrarLeitura(15);
	    novafatura.registraPagamento(150); // Pagamento igual ao valor total da fatura

	    assertTrue(novafatura.isQuitada());
	}

    @Test
    void testRegistraPagamentoValorRestante() {
        Date data = new Date();
        Cliente cliente = new Cliente("jose", 32);
        Imovel imovel = new Imovel(12, "rua", cliente);
        Fatura novafatura = new Fatura(imovel, 20, 10, data);

        novafatura.registrarLeitura(15);
        novafatura.registraPagamento(10); // Pagamento menor que o valor total da fatura

        assertFalse(novafatura.isQuitada());
        assertEquals(10, novafatura.getValorPago(), 0.001); // Valor restante deve ser 10
    }
}
