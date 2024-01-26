package empresaDeOnibus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;




public class Motoristas {
	
	private String nomeMotorista;
	private int cpfMotorista;
	private static List<Motoristas> listaMotoristas = new ArrayList<>();
	




	public Motoristas() {
	}
	


	public Motoristas(String nomeMotorista, int cpfMotorista) {
        this.nomeMotorista = nomeMotorista;
        this.cpfMotorista = cpfMotorista;
        // Adiciona a instância atual à lista
        listaMotoristas.add(this);
    }

    public static void salvarDados() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("dadosMotoristas.txt"))) {
            for (Motoristas motorista : listaMotoristas) {
                writer.write(motorista.nomeMotorista + "," + motorista.cpfMotorista);
                writer.newLine();
            }
            System.out.println("Dados dos motoristas salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados dos motoristas: " + e.getMessage());
        }
    }

    public static void carregarDados() {
        try (BufferedReader reader = new BufferedReader(new FileReader("dadosMotoristas.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                Motoristas motorista = new Motoristas(dados[0], Integer.parseInt(dados[1].trim()));
            }
            System.out.println("Dados dos motoristas carregados com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao carregar dados dos motoristas: " + e.getMessage());
        }
    }
	
	    


	public int getCpfMotorista() {
		return cpfMotorista;
	}



	public void setCpfMotorista(int cpfMotorista) {
		this.cpfMotorista = cpfMotorista;
	}



	public String getNomeMotorista() {
		return nomeMotorista;
	}



	public void setNomeMotorista(String nomeMotorista) {
		this.nomeMotorista = nomeMotorista;
	}
}
