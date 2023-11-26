package conversordemoedas;
import java.util.Scanner;

public class conversordemoedas {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Insira a quantidade em dólares: ");
	        double quantidadeDolares = scanner.nextDouble();

	        System.out.print("Insira a taxa de câmbio para a moeda desejada: ");
	        double taxaCambio = scanner.nextDouble();

	        double valorConvertido = quantidadeDolares * taxaCambio;

	        System.out.println("O valor convertido é: " + valorConvertido);
	 }
}