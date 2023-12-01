from products_functions import add_product, remove_product, list_products, getByCode

def main():
    products = []

    while True:
        print("O que deseja fazer?")
        print("1. Inserir um novo produto")
        print("2. Excluir um produto cadastrado")
        print("3. Listar todos os produtos com seus respectivos códigos e preços")
        print("4. Consultar o preço de um produto através de seu código")
        print("5. Sair")

        opcao = input("Digite sua opção: ")

        match opcao:
            case '1':
                products.append(add_product(products))
            case '2':
                remove_product(products)
            case '3':
                list_products(products)
            case '4':
                getByCode(products)
            case '5':
                print("Saindo...")
                break
            case _:
                print("Entrada inválida!!!!!")


if __name__ == "__main__":
    main()