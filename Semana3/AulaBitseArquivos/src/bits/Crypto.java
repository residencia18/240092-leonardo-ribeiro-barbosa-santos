package bits;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Crypto {


	public static void main(String[] args) {
		String banho1 = args[0];
		String banho2 = args[1];
		String password = args[2];
		System.out.println(banho1);
		System.out.println(banho2);
		System.out.println(password);



		Crypto.processos(banho1, banho2);
		Crypto.lerbits(banho1, banho2, password);
		Crypto.descryption(banho1, banho2, password);
	}


	static void processos(String banho1, String banho2) {


		Path sourcePath = Paths.get(banho1);
		Path destinationPath = Paths.get(banho2);

		try {
			byte[] fileBytes = Files.readAllBytes(sourcePath);
			Files.write(destinationPath, fileBytes);
		} catch (IOException e) {
			System.err.println("Erro ao copiar o arquivo: " + e.getMessage());
			e.printStackTrace();
		}
	}

	static void lerbits(String banho1, String banho2, String password) {

		try (FileInputStream fis1 = new FileInputStream(banho1);
				FileInputStream fis2 = new FileInputStream(banho2);
				FileOutputStream fos = new FileOutputStream(password)) {

			int data1, data2;
			while ((data1 = fis1.read()) != -1 && (data2 = fis2.read()) != -1) {
				// Aplica a operação XOR entre os bytes lidos dos dois arquivos
				int resultado = data1 ^ data2;

				// Escreve o resultado no arquivo de saída
				fos.write(resultado);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void descryption (String banho1, String banho2, String password) {
		try (FileInputStream fis1 = new FileInputStream(banho2);
				FileInputStream fis2 = new FileInputStream(password);
				FileOutputStream fos = new FileOutputStream(banho1)) {

			int data1, data2;
			while ((data1 = fis1.read()) != -1 && (data2 = fis2.read()) != -1) {
				// Aplica a operação XOR entre os bytes lidos dos dois arquivos
				int resultado = data1 ^ data2;

				// Escreve o resultado no arquivo de saída
				fos.write(resultado);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}



