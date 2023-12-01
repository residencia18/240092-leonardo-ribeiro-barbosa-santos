def add_product(products):
    code = input("Informe a código do produto: ")

    while True:
        encontrado = False
        if(len(code) == 13):
            for product in products:
                if code == product["code"]:
                    encontrado = True
            if encontrado:
                print("Código já existe!")
                code = input("Informe a código do produto novamente: ")
            else: 
                break
        else:
            print("Código precisar ter 13 dígitos")
            code = input("Informe a código do produto novamente: ")

    name = input("Informe a nome do produto: ")
    name = name.capitalize()
    price = float(input("Informe o preço do produto: "))

    return { "code": code, "name": name, "price": price }

def remove_product(products):
    code = input("Informe a código do produto: ")
    for product in products:
        if product['code'] == code:
            products.remove(product)
            break
    else:
        print("Produto não encontrado")

def list_products(products):
    sorted_products = sorted(products, key=lambda x: x["price"])

    for i in range(0, len(sorted_products), 10):
        sublista = sorted_products[i:i + 10]
        for element in sublista:
            print("Código:", element["code"], "-", "Nome do produto:", element["name"], "-", "Preço do produto: R$", ("%.2f" % element["price"]))
        print("\n")

def getByCode(products):
    code = input("Informe a código do produto: ")
    for product in products:
        if product['code'] == code:
            print("Código:", product["code"], "-", "Nome do produto:", product["name"], "-", "Preço do produto: R$", ("%.2f" % product["price"]))
            break
    else:
        print("Produto não encontrado")