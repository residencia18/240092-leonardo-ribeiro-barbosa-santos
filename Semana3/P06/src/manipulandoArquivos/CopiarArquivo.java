package manipulandoArquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopiarArquivo {

	public static void main(String[] args) {

		String nomeArquivoOrigem = "C:\\Users\\user\\OneDrive\\Documents\\java\\origem.txt";
		String nomeArquivoDestino = "C:\\Users\\user\\OneDrive\\Documents\\java\\destino.txt";

		try (BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivoOrigem));
				BufferedWriter escritor = new BufferedWriter(new FileWriter(nomeArquivoDestino))) {


			String linha;
			while ((linha = leitor.readLine()) != null) {
				escritor.write(linha);
				escritor.newLine(); 
			}

			System.out.println("Conteúdo de " + nomeArquivoOrigem + " copiado para " + nomeArquivoDestino);

		} catch (IOException e) {
			System.err.println("Erro ao copiar o arquivo: " + e.getMessage());
		}
	}
}


