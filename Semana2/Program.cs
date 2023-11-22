List<(string titulo, string descricao, DateTime data)> tarefas = new List<(string, string, DateTime)>();


System.Console.WriteLine("Escolha o que deseja: \n 1. Criar uma tarefa\n 2. Listar tarefas");
int escolha = int.Parse(Console.ReadLine());

if(escolha == 1)
{
    
    System.Console.WriteLine("1. Crie uma tarefa: ");
    string titulo = Console.ReadLine();

    System.Console.WriteLine("Qual a descrição: ");
    string descricao = Console.ReadLine();

    System.Console.WriteLine("Data de Vencimento (formato dd/mm/yyyy): ");
    if(DateTime.TryParse(Console.ReadLine(), out DateTime data)) // conversão de string para DateTime
    {
        tarefas.Add((titulo, descricao, data));
        System.Console.WriteLine("Tarefa criada com sucesso!");
    }
    else
    {
        System.Console.WriteLine("Formato de data invalido. A tarefa não foi criada com exito.");
    }
}



else if(escolha == 2)
{
    //Listar de tarefas
    System.Console.WriteLine("2. Lista de tarefas:");
    for (int i = 0; i < tarefas.Count; i++)
    {
        System.Console.WriteLine($"Tarefa {i + 1}. Titulo: {tarefas[i].titulo}, Descrição: {tarefas[i].descricao}, Data: {tarefas[i].data}");
    }
     
}      
else
{
    System.Console.WriteLine("Escolha invalida.");
}
   




/*
adicionar_tarefa("Estudar", "Praticar a sintaxe de c#", DateTime.Now);
adicionar_tarefa("Almoçar", "Indo pra casa", DateTime.Now.AddHours(1));


void adicionar_tarefa(string titulo, string descricao, DateTime data)
{
    tarefas.Add((titulo, descricao, data));
    System.Console.WriteLine("Tarefa Adicionada");
}
*/







/*tarefas.Add(("Estudar", DateTime.Now));
tarefas.Add(("Almoçar", DateTime.Now));



for (int i = 0; i < tarefas.Count; i++)
{
    System.Console.WriteLine($"tarefa:  + {tarefas[i]}");
}
*/
