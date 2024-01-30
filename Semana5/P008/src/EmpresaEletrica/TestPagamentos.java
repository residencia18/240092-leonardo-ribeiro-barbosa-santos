package EmpresaEletrica;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

public class TestPagamentos {

    @Test
    public void testRegistraPagamentoFaturaQuitada() {
        // Criando uma fatura com um valor de 100
        Imovel imovel = new Imovel(0, "Endereco", new Cliente("Nome", 123456));
        Fatura fatura = new Fatura(imovel, 100, 200, new Date());

        // Registrando um pagamento igual ao valor total da fatura
        fatura.registraPagamento(100);

        // Verificando se a fatura foi quitada corretamente
        assertTrue(fatura.isQuitada());

        // Verificando se a mensagem de pagamento e quitação da fatura foi exibida corretamente
        assertEquals("Pagamento registrado com sucesso de 100.0 A fatura foi quitada.", fatura.getLeituraAtual());
    }
}
