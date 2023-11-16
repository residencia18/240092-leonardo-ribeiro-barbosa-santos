package conversor_de_temperatura;
import java.util.Scanner;

public class ConversorTemperatura {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Conversor de Temperatura");
        System.out.print("Digite a temperatura: ");
        double temperatura = scanner.nextDouble();

        System.out.println("Escolha a unidade de origem:");
        System.out.println("1. Celsius");
        System.out.println("2. Fahrenheit");

        int escolhaUnidade = scanner.nextInt();

        double resultado = 0;

        switch (escolhaUnidade) {
            case 1:
            	resultado = fahrenheitParaCelsius(temperatura);
                System.out.println("Resultado: " + resultado + " Celsius");
                break;
                
            case 2:
            	resultado = celsiusParaFahrenheit(temperatura);
                System.out.println("Resultado: " + resultado + " Fahrenheit");
                break;
            default:
                System.out.println("Escolha inválida.");
                return;
        }
    }

    private static double celsiusParaFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    private static double fahrenheitParaCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}
