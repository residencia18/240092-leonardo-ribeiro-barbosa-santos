List<(string, string, DateTime)> tarefas = new List<(string, string, DateTime)>();





adicionar_tarefa(("Estudar", "Praticar a sintaxe de c#", DateTime.Now));
adicionar_tarefa(("Almoçar", "Indo pra casa", DateTime.Now(1)));


void adicionar_tarefa(string tarefa, string descricao, DateTime data)
{
    tarefas.Add((tarefa, descricao, data));
}








/*tarefas.Add(("Estudar", DateTime.Now));
tarefas.Add(("Almoçar", DateTime.Now));



for (int i = 0; i < tarefas.Count; i++)
{
    System.Console.WriteLine($"tarefa:  + {tarefas[i]}");
}
*/
