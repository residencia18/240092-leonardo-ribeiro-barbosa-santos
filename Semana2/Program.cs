List<(string titulo, string descricao, DateTime data)> tarefas = new List<(string, string, DateTime)>();


System.Console.WriteLine("Criei uma tarefa: ");
string titulo = Console.ReadLine();

System.Console.WriteLine("Qual a descrição: ");
string descricao = Console.ReadLine();

System.Console.WriteLine("Data de Vencimento (formato dd/mm/yyyy): ");
if(DateTime.TryParse(Console.ReadLine(), out DateTime data)) 
{
    tarefas.Add((titulo, descricao, data));
    System.Console.WriteLine("Tarefa criada com sucesso!");
}
else
{
    System.Console.WriteLine("Formato de data invalido. A tarefa não foi criada com exito.");
}

    //Listar de tarefas
    System.Console.WriteLine("Lista de tarefas:");
    for (int i = 0; i < tarefas.Count; i++)
    {
        System.Console.WriteLine($"Tarefa {i + 1}. Titulo: {titulo}, Descrição: {descricao}, Data: {data}");
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
