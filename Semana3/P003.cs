using System;
using System.Collections.Generic;

namespace ControleEstoque
{
    class Program
    {
        static List<Produto> estoque = new List<Produto>();

        static void Main(string[] args)
        {
            // Exemplo de uso
            CadastrarProduto();

            // Consulta de produtos
            try
            {
                Console.WriteLine("\nConsulta de Produto por Código:");
                Console.Write("Digite o código do produto: ");
                int codigoConsulta = int.Parse(Console.ReadLine());

                var produtoConsultado = ConsultarProdutoPorCodigo(codigoConsulta);

                Console.WriteLine($"Nome: {produtoConsultado.Nome}");
                Console.WriteLine($"Quantidade em Estoque: {produtoConsultado.QuantidadeEmEstoque}");
                Console.WriteLine($"Preço Unitário: {produtoConsultado.PrecoUnitario:C}");
            }
            catch (ProdutoNaoEncontradoException ex)
            {
                Console.WriteLine($"Erro: {ex.Message}");
            }
            catch (FormatException)
            {
                Console.WriteLine("Erro: Entrada inválida. Certifique-se de inserir um código válido.");
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Erro inesperado: {ex.Message}");
            }

            // Atualização de Estoque
            try
            {
                Console.WriteLine("\nAtualização de Estoque:");
                Console.Write("Digite a quantidade a ser adicionada (negativa para saída): ");
                int quantidadeAtualizacao = int.Parse(Console.ReadLine());

                AtualizarEstoque(estoque[0], quantidadeAtualizacao); // Atualizando o primeiro produto como exemplo
                Console.WriteLine($"Estoque atualizado: {estoque[0].QuantidadeEmEstoque}");
            }
            catch (QuantidadeInsuficienteException ex)
            {
                Console.WriteLine($"Erro: {ex.Message}");
            }
            catch (FormatException)
            {
                Console.WriteLine("Erro: Entrada inválida. Certifique-se de inserir um valor válido.");
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Erro inesperado: {ex.Message}");
            }
        }

        // Função para cadastrar produto
        static void CadastrarProduto()
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
        }

        // Função para consultar produto por código
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

        // Função para atualizar o estoque
        static void AtualizarEstoque(Produto produto, int quantidade)
        {
            if (produto.QuantidadeEmEstoque + quantidade < 0)
            {
                throw new QuantidadeInsuficienteException($"Quantidade insuficiente em estoque para uma saída de {Math.Abs(quantidade)} unidades.");
            }

            produto.QuantidadeEmEstoque += quantidade;
        }
    }

    // Definição da estrutura da tupla
    public class Produto
    {
        public int Codigo { get; set; }
        public string Nome { get; set; }
        public int QuantidadeEmEstoque { get; set; }
        public decimal PrecoUnitario { get; set; }
    }

    // Exceção personalizada para produto não encontrado
    public class ProdutoNaoEncontradoException : Exception
    {
        public ProdutoNaoEncontradoException(string mensagem) : base(mensagem)
        {
        }
    }

    // Exceção personalizada para quantidade insuficiente em estoque
    public class QuantidadeInsuficienteException : Exception
    {
        public QuantidadeInsuficienteException(string mensagem) : base(mensagem)
        {
        }
    }
}
