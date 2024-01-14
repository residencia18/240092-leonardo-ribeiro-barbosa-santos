package manipulandoArquivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeituraDeArquivos {

	public static void main(String[] args) {
        String nomeArquivo = "C:\\Users\\user\\OneDrive\\Documents\\java\\entrada.txt";

        try (BufferedReader leitor = new BufferedReader(new FileReader("C:\\Users\\user\\OneDrive\\Documents\\java\\entrada.txt"))) {
            System.out.println("entrada.txt");
            
            String linha;
            while ((linha = leitor.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            // Trata exceções de leitura de arquivo
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}

	

