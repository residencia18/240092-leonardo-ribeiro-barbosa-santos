class Program
{
    static List<Tarefa> tarefas = new List<Tarefa>();

    static void Main()
    {
        while (true)
        {
            Console.WriteLine("Escolha o que deseja: \n 1. Criar uma tarefa\n 2. Listar tarefas\n 3. Marcar tarefa como concluída\n 4. Listar tarefas concluídas\n 5. Excluir tarefa\n 6. Pesquisar tarefas por palavra-chave\n 7. Exibir estatísticas\n 8. Sair");
            int escolha = int.Parse(Console.ReadLine());

            switch (escolha)
            {
                case 1:
                    CriarTarefa();
                    break;
                case 2:
                    ListarTarefas(tarefas.Where(t => !t.Concluida).ToList());
                    break;
                case 3:
                    MarcarTarefaConcluida();
                    break;
                case 4:
                    ListarTarefas(tarefas.Where(t => t.Concluida).ToList());
                    break;
                case 5:
                    ExcluirTarefa();
                    break;
                case 6:
                    PesquisarPorPalavraChave();
                    break;
                case 7:
                    ExibirEstatisticas();
                    break;
                case 8:
                    Environment.Exit(0);
                    break;
                default:
                    Console.WriteLine("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}
