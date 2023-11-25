tarefas = []
linhas = []

try:
    with open('tarefas.txt', 'r') as arquivo:
        linhas = arquivo.readlines()
except:
    pass

if len(linhas) > 0:
    for linha in linhas:
        tarefas.append((linha.split()[0], linha.split()[1].rstrip('\n'), linha.split()[2]))

id = len(tarefas)

while True:
    print("O que deseja fazer?")
    print("1. Registrar nova tarefa")
    print("2. Listar tarefas")
    print("3. Marcar tarefa como realizada")
    print("4. Editar tarefa")
    print("5. Sair")

    opcao = input("Digite sua opção: ")

    match opcao:
        case '1':
            descricao = input("Digite a descricao da tarefa: ")
            descricao = descricao.capitalize()
            tarefas.append((str(id) + ".", descricao, '[]'))

            with open('tarefas.txt', 'a') as f:
                f.write(tarefas[-1][0] + " " + tarefas[-1][1] + " " + tarefas[-1][2] + "\n")

            print(f"Tarefa '{descricao}' registrada!!!")

            id += 1
        case '2':
            if len(tarefas) > 0:
                print("Tarefas registradas:")
                for i in range(len(tarefas)):
                    print(tarefas[i][0] + " " + tarefas[i][1] + " " + tarefas[i][2])
            else:
                print("Nenhuma tarefa registrada!")
        case '3':
            print("Escolha a tarefa a ser concluída:")
            for i in range(len(tarefas)):
                print(tarefas[i][0] + " " + tarefas[i][1] + " " + tarefas[i][2])
            index_tarefa = input("Digite o número referente a tarefa: ")
            index_tarefa = int(index_tarefa)

            if 0 <= index_tarefa < len(tarefas):
                if tarefas[index_tarefa][2] == "[]":
                    tarefas[index_tarefa] = (tarefas[index_tarefa][0], tarefas[index_tarefa][1], "[x]")
                    with open('tarefas.txt', 'w') as arquivo:
                        for tarefa in tarefas:
                            arquivo.write(tarefa[0] + " " + tarefa[1] + " " + tarefa[2] + "\n")
                    print(f"Tarefa {tarefas[index_tarefa][1]} concluída!")
                else:
                    print("Tarefa já estava concluída!")
            else:
                print("Essa tarefa não existe!")

        case '4':
            print("Escolha a tarefa a ser editada:")
            for i in range(len(tarefas)):
                print(tarefas[i][0] + " " + tarefas[i][1] + " " + tarefas[i][2])
            index_tarefa = input("Digite o número referente a tarefa: ")
            index_tarefa = int(index_tarefa)

            if 0 <= index_tarefa < len(tarefas):
                descricao = input("Digite a nova descrição: ")
                descricao = descricao.capitalize()

                if descricao != "" or descricao != " ":
                    tarefas[index_tarefa] = (tarefas[index_tarefa][0], descricao, tarefas[index_tarefa][2])
                    with open('tarefas.txt', 'w') as arquivo:
                        for tarefa in tarefas:
                            arquivo.write(tarefa[0] + " " + tarefa[1] + " " + tarefa[2] + "\n")
                    print("Tarefa editada com sucesso!")
                else:
                    print("Digite uma descrição válida!")
            else:
                print("Essa tarefa não existe!")
        case '5':
            print("Saindo...")
            break
        case _:
            print("Entrada inválida!!!!!")