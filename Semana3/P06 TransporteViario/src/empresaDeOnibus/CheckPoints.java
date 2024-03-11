package empresaDeOnibus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CheckPoints {
	private LocalDateTime horarioChegada;

	
	
	

	public CheckPoints() {
	}


	public void registrarChegada() {
        this.horarioChegada = LocalDateTime.now();

        // Define o formato brasileiro para o checkpoint
        DateTimeFormatter formatoCheckpoint = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String chegadaFormatada = horarioChegada.format(formatoCheckpoint);

        System.out.println("Veículo chegou ao checkpoint "  + " às " + chegadaFormatada);
    }
	  public void salvarDados() {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter("dadosCheckPoints.txt", true))) {
	            writer.write(horarioChegada.toString());
	            writer.newLine();
	            System.out.println("Dados do checkpoint salvos com sucesso.");
	        } catch (IOException e) {
	            System.out.println("Erro ao salvar dados do checkpoint: " + e.getMessage());
	        }
	    }

	    public void carregarDados() {
	        try (BufferedReader reader = new BufferedReader(new FileReader("dadosCheckPoints.txt"))) {
	            String linha;
	            while ((linha = reader.readLine()) != null) {
	                LocalDateTime chegada = LocalDateTime.parse(linha);
	                System.out.println("Veículo chegou ao checkpoint às " + chegada);
	            }
	            System.out.println("Dados dos checkpoints carregados com sucesso.");
	        } catch (IOException e) {
	            System.out.println("Erro ao carregar dados dos checkpoints: " + e.getMessage());
	        }
	    }
	}

