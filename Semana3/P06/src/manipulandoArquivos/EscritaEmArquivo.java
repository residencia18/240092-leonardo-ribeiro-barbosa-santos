package manipulandoArquivos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EscritaEmArquivo {


	public static void main(String[] args) {


		String nomeArquivo = "C:\\Users\\user\\OneDrive\\Documents\\java\\saida.txt";

		try (Scanner scanner = new Scanner(System.in);
				BufferedWriter escritor = new BufferedWriter(new FileWriter(nomeArquivo))) {

			System.out.println("Digite várias linhas de texto. Pressione Enter para finalizar.");

			String linha;
			while (!(linha = scanner.nextLine()).isEmpty()) {
				escritor.write(linha);
				escritor.newLine(); 
				System.out.println("Texto gravado: " + linha);
			}
			System.out.println("Linhas de texto foram gravadas em " + nomeArquivo);

		} catch (IOException e) {
			System.err.println("Erro ao gravar no arquivo: " + e.getMessage());


		}
	}
}





