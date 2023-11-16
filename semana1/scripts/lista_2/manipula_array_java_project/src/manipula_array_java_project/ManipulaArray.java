package manipula_array_java_project;
import java.util.Scanner;
import java.util.Random;

public class ManipulaArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criando array a partir da entrada do usuário
        System.out.println("Digite o tamanho do array:");
        int tamanho = scanner.nextInt();
        int[] arrayUsuario = criarArrayUsuario(tamanho);

        // Imprimindo array gerado pelo usuário
        System.out.println("Array gerado pelo usuário:");
        imprimirArray(arrayUsuario);

        // Criando array aleatório
        int[] arrayAleatorio = criarArrayAleatorio(tamanho);

        // Imprimindo array gerado aleatoriamente
        System.out.println("Array gerado aleatoriamente:");
        imprimirArray(arrayAleatorio);

        // Calculando e exibindo a soma dos elementos no array gerado pelo usuário
        int somaUsuario = calcularSoma(arrayUsuario);
        System.out.println("Soma dos elementos no array gerado pelo usuário: " + somaUsuario);

        // Encontrando e exibindo o maior valor no array aleatório
        int maiorValor = encontrarMaiorValor(arrayAleatorio);
        System.out.println("Maior valor no array aleatório: " + maiorValor);

        // Encontrando e exibindo o menor valor no array aleatório
        int menorValor = encontrarMenorValor(arrayAleatorio);
        System.out.println("Menor valor no array aleatório: " + menorValor);

        scanner.close();
    }

    // Método para criar um array de números inteiros lidos do usuário
    private static int[] criarArrayUsuario(int tamanho) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[tamanho];

        System.out.println("Digite os elementos do array:");

        for (int i = 0; i < tamanho; i++) {
            array[i] = scanner.nextInt();
        }

        return array;
    }

    // Método para criar um array de números inteiros aleatórios
    private static int[] criarArrayAleatorio(int tamanho) {
        Random random = new Random();
        int[] array = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            array[i] = random.nextInt(100); // Gera números aleatórios até 100
        }

        return array;
    }

    // Método para calcular a soma dos elementos no array
    private static int calcularSoma(int[] array) {
        int soma = 0;

        for (int elemento : array) {
            soma += elemento;
        }

        return soma;
    }

    // Método para encontrar o maior valor no array
    private static int encontrarMaiorValor(int[] array) {
        int maior = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > maior) {
                maior = array[i];
            }
        }

        return maior;
    }

    // Método para encontrar o menor valor no array
    private static int encontrarMenorValor(int[] array) {
        int menor = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < menor) {
                menor = array[i];
            }
        }

        return menor;
    }

    // Método para imprimir os elementos de um array
    private static void imprimirArray(int[] array) {
        for (int elemento : array) {
            System.out.print(elemento + " ");
        }
        System.out.println();
    }
}

