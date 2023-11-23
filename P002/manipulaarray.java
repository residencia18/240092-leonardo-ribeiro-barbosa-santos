package manipulaarray;
import java.util.Scanner;
import java.util.Random;

public class ManipulaArray {
    private int[] array;

    public void criarArrayManualmente() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o tamanho do array: ");
        int tamanho = scanner.nextInt();

        array = new int[tamanho];

        System.out.println("Digite os elementos do array:");

        for (int i = 0; i < tamanho; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }

        scanner.close();
    }

    public void criarArrayAleatoriamente(int tamanho, int valorMaximo) {
        Random random = new Random();
        array = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            array[i] = random.nextInt(valorMaximo + 1);
        }
    }

    public int calcularSoma() {
        int soma = 0;
        for (int num : array) {
            soma += num;
        }
        return soma;
    }

    public int encontrarMaiorValor() {
        int maior = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maior) {
                maior = array[i];
            }
        }
        return maior;
    }

    public int encontrarMenorValor() {
        int menor = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < menor) {
                menor = array[i];
            }
        }
        return menor;
    }

    public static void main(String[] args) {
        ManipulaArray manipulaArray = new ManipulaArray();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha uma opção:");
        System.out.println("1. Criar um array manualmente");
        System.out.println("2. Criar um array aleatoriamente");

        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                manipulaArray.criarArrayManualmente();
                break;
            case 2:
                System.out.print("Digite o tamanho do array: ");
                int tamanho = scanner.nextInt();
                System.out.print("Digite o valor máximo para os elementos do array: ");
                int valorMaximo = scanner.nextInt();
                manipulaArray.criarArrayAleatoriamente(tamanho, valorMaximo);
                break;
            default:
                System.out.println("Opção inválida.");
                scanner.close();
                return;
        }

        System.out.println("\nArray criado:");
        for (int num : manipulaArray.array) {
            System.out.print(num + " ");
        }
        System.out.println();

        int soma = manipulaArray.calcularSoma();
        System.out.println("Soma dos elementos do array: " + soma);

        int maiorValor = manipulaArray.encontrarMaiorValor();
        System.out.println("Maior valor do array: " + maiorValor);

        int menorValor = manipulaArray.encontrarMenorValor();
        System.out.println("Menor valor do array: " + menorValor);

    }
}
