
listaDeTarefas = []

def adicionar_tarefas(listaDeTarefas):
    tarefa = input("Crie sua tarefa: ")
    listaDeTarefas.append(tarefa)
    print("Tarefa adicionada com sucesso!")




adicionar_tarefas(listaDeTarefas)


def listar_tarefas(listaDeTarefas):
    print()
    for tarefa in listaDeTarefas:
        print(tarefa,"[]")
 
listar_tarefas(listaDeTarefas)



def tarefa_concluida(listaDeTarefas):
   if(id(listaDeTarefas)):
       print("Tarefa Concluida",)

tarefa_concluida(listaDeTarefas)
       



