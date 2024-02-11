package EmpresaEletrica;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Date;

public class FaturaTest {
    private Imovel imovel;
    private Fatura fatura;
    
    @Before
    public void setUp() {
        // Cria um imóvel para ser usado nos testes
        imovel = new Imovel(/* parâmetros do construtor */);
        
        // Cria uma fatura para o imóvel
        Date dataEmissao = new Date();
        fatura = new Fatura(imovel, dataEmissao);
    }
    
    @Test
    public void testRegistrarLeitura() {
        // Verifica se a leitura atual está inicialmente como zero
        assertEquals(0.0, fatura.getLeituraAtual(), 0.001);
        
        // Registra uma leitura válida
        double leitura = 100.0; // Defina o valor da leitura
        fatura.registrarLeitura(leitura);
        
        // Verifica se a leitura atual foi atualizada corretamente
        assertEquals(leitura, fatura.getLeituraAtual(), 0.001);
    }
    
    @Test(expected = IllegalStateException.class)
    public void testRegistrarLeituraMaisDeUmaVez() {
        // Registra uma leitura válida pela primeira vez
        double leitura = 100.0; // Defina o valor da leitura
        fatura.registrarLeitura(leitura);
        
        // Tenta registrar a mesma leitura novamente, o que deve lançar uma IllegalStateException
        fatura.registrarLeitura(leitura);
    }
}
