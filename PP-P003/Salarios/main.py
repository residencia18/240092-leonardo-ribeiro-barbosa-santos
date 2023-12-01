from employees_functions import add_employee, remove_employee, get_employees, list_employees, list_employees_before_readjustment, list_employees_after_readjustment

def main():
    employees = get_employees()

    while True:
        print("O que deseja fazer?")
        print("1. Adicionar funcionário")
        print("2. Excluir funcionário")
        print("3. Listar todos os funcionários")
        print("4. Reajustar salário")
        print("5. Sair")

        opcao = input("Digite sua opção: ")

        match opcao:
            case '1':
                employees.append(add_employee())
            case '2':
                remove_employee(employees)
            case '3':
                list_employees(employees)
            case '4':
                list_employees_before_readjustment(employees)
                list_employees_after_readjustment(employees)
            case '5':
                print("Saindo...")
                break
            case _:
                print("Entrada inválida!!!!!")

if __name__ == "__main__":
    main()