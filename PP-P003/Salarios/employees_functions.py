import math

def add_employee():
    name = input("Informe o nome do funcionário: ")
    name = name.capitalize()
    lastname = input("Informe o sobrenome do funcionário: ")
    lastname = lastname.capitalize()
    bith_date = input("Informe o ano de nascimento do funcionário: ")
    rg = input("Informe o RG do funcionário: ")
    year_admission = input("Informe o ano de admissão do funcionário: ")
    salary = float(input("Informe o salário do funcionário: "))

    with open('employees.txt', 'a') as f:
        f.write(f"{name},{lastname},{bith_date},{rg},{year_admission},{salary}\n")

    return { "name": name, "lastname": lastname, "bith_date": bith_date, "rg": rg, "year_admission": year_admission, "salary": salary }

def remove_employee(employees):
    name = input("Informe a nome do funcionário: ")
    lastname = input("Informe o sobrenome do funcionário: ")
    for employee in employees:
        if employee['name'] == name and employee['lastname'] == lastname:
            employees.remove(employee)
            break
    else:
        print("Funcionário não encontrado")

def list_employees(employees):
    if len(employees) > 0:
        print("Funcionários:")
        for employee in employees:
            print(f"Nome: {employee['name']} {employee['lastname']} - Data de Nascimento: {employee['bith_date']} - RG: {employee['rg']} - Ano de admissão: {employee['year_admission']} - Salario: {employee['salary']}")
    else:
        print("Nenhuma tarefa registrada!")

def reajusta_dez_porcento(employees):
    for employee in employees:
        employee['salary'] *= 1.1
        employee['salary'] = math.ceil(employee['salary'])

def get_employees():
    employees = []

    with open('employees.txt', 'r') as file:
        for linha in file:
            datas = linha.strip().split(',')
            name, lastname, bith_date, rg, year_admission, salary = datas
            employees.append({
                'name': name,
                'lastname': lastname,
                'bith_date': int(bith_date),
                'rg': rg,
                'year_admission': int(year_admission),
                'salary': float(salary)
            })

    return employees

def list_employees_before_readjustment(employees):
    print("\nFuncionários com salário antes do reajuste: ")
    for employee in employees:
        print(f"Nome: {employee['name']} {employee['lastname']} - Data de Nascimento: {employee['bith_date']} - RG: {employee['rg']} - Ano de admissão: {employee['year_admission']} - Salario: {employee['salary']}")

def list_employees_after_readjustment(employees):
    reajusta_dez_porcento(employees)
    print("\nFuncionários com salário depois do reajuste: ")

    with open('employees.txt', 'w') as f:
        for employee in employees:
            f.write(f"{employee['name']},{employee['lastname']},{employee['bith_date']},{employee['rg']},{employee['year_admission']},{employee['salary']}\n")

    for employee in employees:
        print(f"Nome: {employee['name']} {employee['lastname']} - Data de Nascimento: {employee['bith_date']} - RG: {employee['rg']} - Ano de admissão: {employee['year_admission']} - Salario: {employee['salary']}")