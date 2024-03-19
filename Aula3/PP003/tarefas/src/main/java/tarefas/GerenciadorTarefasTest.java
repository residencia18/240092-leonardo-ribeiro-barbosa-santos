package tarefas;

import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import com.leo.tarefas.exception.TarefaInvalidaException;

public class GerenciadorTarefasTest {

    @Test
    public void adicionarTarefaSemTitulo_DeveLancarExcecao() {
        GerenciadorTarefas gerenciadorTarefas = new GerenciadorTarefas();
        Tarefas tarefa = new Tarefas(null, "Descrição da tarefa", false);

        assertThrows(TarefaInvalidaException.class, () -> {
            gerenciadorTarefas.adicionarTarefa(tarefa);
        });
    }
}
