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

static void CriarTarefa()
    {
        Console.WriteLine("Criar uma tarefa:");

        Console.Write("Título: ");
        string titulo = Console.ReadLine();

        Console.Write("Descrição: ");
        string descricao = Console.ReadLine();


        DateTime data;
        while (true)
        {
            Console.Write("Data de Vencimento (formato dd/mm/yyyy): ");
            if (DateTime.TryParseExact(Console.ReadLine(), "dd/MM/yyyy", null, System.Globalization.DateTimeStyles.None, out data))
            {
                break;
            }
            else
            {
                Console.WriteLine("Formato de data inválido. Tente novamente.");
            }
        }
    

        Tarefa novaTarefa = new Tarefa(titulo, descricao, data);
        tarefas.Add(novaTarefa);
        Console.WriteLine("Tarefa criada com sucesso!");
    }


static void ListarTarefas(List<Tarefa> listaTarefas)
{
     Console.WriteLine("Lista de tarefas:");

        for (int i = 0; i < listaTarefas.Count; i++)
        {
            Console.WriteLine($"Tarefa {i + 1}. {listaTarefas[i]}");
        }
}





class Tarefa
{
    public string Titulo {get ; set}
    public string Descricao {get ; set}
    public DateTime DataVencimento {get ; set}
    public bool Concluida {get ; set}
    
    public Tarefa(string titulo, string descricao, DateTime dataVencimento)
    {
        Titulo = titulo;
        Descricao = descricao;
        DataVencimento = dataVencimento;
        Concluida = false;
    }

    public override string ToString()
    {
        return $"{Titulo}, Descrição: {Descricao}, Data de Vencimento: {DataVencimento:dd/MM/yyyy}, {(Concluida ? "Concluída" : "Pendente")}";
    }
}
