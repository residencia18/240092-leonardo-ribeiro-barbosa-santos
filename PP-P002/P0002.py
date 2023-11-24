# Lista de tarefas
tarefas = []

# Listar tarefas
print("Lista de Tarefas:")
for i, tarefa in enumerate(tarefas, start=1):
    print(f"{i}. {tarefa}")

# Registrar uma nova tarefa
descricao = input("Digite a descrição da nova tarefa: ")
if descricao[0].isupper():
    tarefas.append(f"{len(tarefas) + 1}.{descricao} [ ]")
    print("Tarefa registrada!!!")
else:
    print("A descrição da tarefa deve começar com letra maiúscula.")

# Listar tarefas
print("Lista de Tarefas:")
for i, tarefa in enumerate(tarefas, start=1):
    print(f"{i}. {tarefa}")

# Marcar uma tarefa como realizada
identificador = input("Digite o identificador da tarefa a ser marcada como realizada: ")
try:
    indice_tarefa = int(identificador) - 1
    if 0 <= indice_tarefa < len(tarefas):
        if "[ ]" in tarefas[indice_tarefa]:
            tarefas.insert(0, tarefas.pop(indice_tarefa).replace("[ ]", "[x]"))
            print("Tarefa marcada como realizada!")
        else:
            print("Esta tarefa já foi realizada.")
    else:
        print("Identificador de tarefa inválido.")
except ValueError:
    print("Digite um número válido para o identificador da tarefa.")

# Listar tarefas
print("Lista de Tarefas:")
for i, tarefa in enumerate(tarefas, start=1):
    print(f"{i}. {tarefa}")

# Editar uma tarefa
identificador_editar = input("Digite o identificador da tarefa a ser editada: ")
try:
    indice_tarefa_editar = int(identificador_editar) - 1
    if 0 <= indice_tarefa_editar < len(tarefas):
        nova_descricao = input("Digite a nova descrição da tarefa: ")
        if "[x]" not in tarefas[indice_tarefa_editar]:
            tarefas[indice_tarefa_editar] = f"{indice_tarefa_editar + 1}.{nova_descricao} {tarefas[indice_tarefa_editar][-4:]}"
            print("Tarefa editada com sucesso!")
        else:
            print("Não é possível editar uma tarefa já realizada.")
    else:
        print("Identificador de tarefa inválido.")
except ValueError:
    print("Digite um número válido para o identificador da tarefa.")
