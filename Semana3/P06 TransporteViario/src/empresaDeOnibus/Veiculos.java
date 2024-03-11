package empresaDeOnibus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Veiculos {
	
	private String placa;
	private String modelo;
	
	
	

	private static List<Veiculos> listaVeiculos = new ArrayList<>();

    public Veiculos() {
    }

    public Veiculos(String placa, String modelo) {
        this.placa = placa;
        this.modelo = modelo;
        // Adiciona a instância atual à lista
        listaVeiculos.add(this);
    }

    public static void salvarDados() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("dadosVeiculos.txt"))) {
            for (Veiculos veiculo : listaVeiculos) {
                writer.write(veiculo.modelo + "," + veiculo.placa);
                writer.newLine();
            }
            System.out.println("Dados dos veículos salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados dos veículos: " + e.getMessage());
        }
    }

    public static void carregarDados() {
        try (BufferedReader reader = new BufferedReader(new FileReader("dadosVeiculos.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length >= 2) {
                    Veiculos veiculo = new Veiculos(dados[0], dados[1]);
                } else {
                    System.out.println("Linha mal formatada no arquivo: " + linha);
                }
            }
            System.out.println("Dados dos veículos carregados com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao carregar dados dos veículos: " + e.getMessage());
        }
    }



	public String getModelo() {
		return modelo;
	}



	public void setModelo(String modelo) {
		this.modelo = modelo;
	}




	public String getPlaca() {
		return placa;
	}



	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	 @Override
	    public String toString() {
	        return "Veículo: " + modelo + " (Placa: " + placa + ")";
	    }
	 
	
}
