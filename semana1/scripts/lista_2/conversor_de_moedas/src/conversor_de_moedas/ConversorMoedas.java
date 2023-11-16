package conversor_de_moedas;
import java.util.Scanner;

public class ConversorMoedas {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita ao usuário a taxa de câmbio
        System.out.print("Digite a taxa de câmbio (por exemplo, 5,50 para converter de dólares para reais): ");
        double taxaCambio = scanner.nextDouble();

        // Solicita ao usuário a quantidade em dólares
        System.out.print("Digite a quantidade em dólares: ");
        double quantidadeDolares = scanner.nextDouble();

        // Calcula o valor convertido
        double valorConvertido = converterMoeda(quantidadeDolares, taxaCambio);

        // Exibe o resultado
        System.out.println("O valor convertido é: " + valorConvertido);

        // Fecha o scanner
        scanner.close();
    }

    // Método para converter a moeda
    public static double converterMoeda(double quantidadeDolares, double taxaCambio) {
        return quantidadeDolares * taxaCambio;
    }
}
