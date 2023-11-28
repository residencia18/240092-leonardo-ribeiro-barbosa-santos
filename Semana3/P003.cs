
    class Program
    {
        static List<Produto> estoque = new List<Produto>();

        static void Main(string[] args)
        {
            bool continuar = true;

            while (continuar)
            {
                Console.WriteLine("Menu:");
                Console.WriteLine("1. Cadastrar Produto");
                Console.WriteLine("2. Consultar Produto por Código");
                Console.WriteLine("3. Atualizar Estoque");
                Console.WriteLine("4. Gerar Relatórios");
                Console.WriteLine("5. Sair");
                Console.Write("Escolha uma opção: ");

                string opcao = Console.ReadLine();

                switch (opcao)
                {
                    case "1":
                        CadastrarProduto();
                        break;
                    case "2":
                        ConsultarProdutoPorCodigoMenu();
                        break;
                    case "3":
                        AtualizarEstoqueMenu();
                        break;
                    case "4":
                        GerarRelatoriosMenu();
                        break;
                    case "5":
                        continuar = false;
                        Console.WriteLine("Saindo do programa.");
                        break;
                    default:
                        Console.WriteLine("Opção inválida. Tente novamente.");
                        break;
                }
            }
        }

        static void CadastrarProduto()
        {
            try
            {
                Console.WriteLine("Cadastro de Produto:");
                Console.Write("Código: ");
                int codigo = int.Parse(Console.ReadLine());

                Console.Write("Nome: ");
                string nome = Console.ReadLine();

                Console.Write("Quantidade em Estoque: ");
                int quantidade = int.Parse(Console.ReadLine());

                Console.Write("Preço Unitário: ");
                decimal preco = decimal.Parse(Console.ReadLine());

                Produto novoProduto = new Produto
                {
                    Codigo = codigo,
                    Nome = nome,
                    QuantidadeEmEstoque = quantidade,
                    PrecoUnitario = preco
                };

                estoque.Add(novoProduto);

                Console.WriteLine("Produto cadastrado com sucesso!");
            }
            catch (FormatException ex)
            {
                Console.WriteLine($"Erro durante o cadastro: {ex.Message}. Certifique-se de inserir um formato válido.");
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Erro inesperado: {ex.Message}");
            }
        }

        static void ConsultarProdutoPorCodigoMenu()
        {
            try
            {
                Console.WriteLine("\nConsulta de Produto por Código:");
                Console.Write("Digite o código do produto: ");
                int codigoConsulta = int.Parse(Console.ReadLine());
                var produtoConsultado = ConsultarProdutoPorCodigo(codigoConsulta);
                ExibirProduto(produtoConsultado);
            }
            catch (FormatException ex)
            {
                Console.WriteLine($"Erro: {ex.Message}. Certifique-se de inserir um formato válido.");
            }
            catch (ProdutoNaoEncontradoException ex)
            {
                Console.WriteLine($"Erro: {ex.Message}");
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Erro inesperado: {ex.Message}");
            }
        }

        static void AtualizarEstoqueMenu()
        {
            try
            {
                Console.WriteLine("\nAtualização de Estoque:");
                Console.Write("Digite o código do produto: ");
                int codigoConsulta = int.Parse(Console.ReadLine());
                var produtoConsultado = ConsultarProdutoPorCodigo(codigoConsulta);

                Console.Write("Digite a quantidade a ser adicionada (negativa para saída): ");
                int quantidadeAtualizacao = int.Parse(Console.ReadLine());
                AtualizarEstoque(produtoConsultado, quantidadeAtualizacao);

                Console.WriteLine($"Estoque atualizado: {produtoConsultado.QuantidadeEmEstoque}");
            }
            catch (FormatException ex)
            {
                Console.WriteLine($"Erro: {ex.Message}. Certifique-se de inserir um formato válido.");
            }
            catch (ProdutoNaoEncontradoException ex)
            {
                Console.WriteLine($"Erro: {ex.Message}");
            }
            catch (QuantidadeInsuficienteException ex)
            {
                Console.WriteLine($"Erro: {ex.Message}");
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Erro inesperado: {ex.Message}");
            }
        }

        static void GerarRelatoriosMenu()
        {
            try
            {
                // Implemente a lógica para gerar relatórios aqui
                // Exemplo:
                Console.WriteLine("\nGerando relatórios...");
                Console.WriteLine("Relatórios gerados com sucesso!");
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Erro inesperado ao gerar relatórios: {ex.Message}");
            }
        }

        static Produto ConsultarProdutoPorCodigo(int codigo)
        {
            var produtoConsultado = estoque.Find(p => p.Codigo == codigo);

            if (produtoConsultado != null)
            {
                return produtoConsultado;
            }
            else
            {
                throw new ProdutoNaoEncontradoException($"Produto com código {codigo} não encontrado.");
            }
        }

        static void AtualizarEstoque(Produto produto, int quantidade)
        {
            if (produto.QuantidadeEmEstoque + quantidade < 0)
            {
                throw new QuantidadeInsuficienteException($"Quantidade insuficiente em estoque para uma saída de {Math.Abs(quantidade)} unidades.");
            }

            produto.QuantidadeEmEstoque += quantidade;
        }

        static void ExibirProduto(Produto produto)
        {
            Console.WriteLine($"Código: {produto.Codigo}, Nome: {produto.Nome}, Quantidade em Estoque: {produto.QuantidadeEmEstoque}, Preço Unitário: {produto.PrecoUnitario:C}");
        }
    }

    public class Produto
    {
        public int Codigo { get; set; }
        public string Nome { get; set; }
        public int QuantidadeEmEstoque { get; set; }
        public decimal PrecoUnitario { get; set; }
    }

    public class CadastroInvalidoException : Exception
    {
        public CadastroInvalidoException(string mensagem) : base(mensagem)
        {
        }
    }

    public class ProdutoNaoEncontradoException : Exception
    {
        public ProdutoNaoEncontradoException(string mensagem) : base(mensagem)
        {
        }
    }

    public class QuantidadeInsuficienteException : Exception
    {
        public QuantidadeInsuficienteException(string mensagem) : base(mensagem)
        {
        }
    }
