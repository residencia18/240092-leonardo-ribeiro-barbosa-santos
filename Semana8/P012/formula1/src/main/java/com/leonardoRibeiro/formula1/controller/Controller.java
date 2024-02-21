package com.leonardoRibeiro.formula1.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@RequestMapping("/todos")
	public static String listaVencedores (){
	
        String caminho = "C:\\Users\\user\\git\\Trilha-Java-TIC18\\Semana8\\P012\\formula1\\src\\main\\resources\\pilotos.csv";
		ArrayList<String> lista = new ArrayList<String>();
		String campo = ";";
 		
		try(BufferedReader br = new BufferedReader(new FileReader(caminho))) {
				
			String linha = br.readLine();
			while(linha != null) {
			    lista.add(linha);
			    String[] coluna = linha.split(campo);
			    System.out.println("País: "+ coluna[0] + "\nPiloto: " + coluna[1] + "\nVitorias: " + coluna[2]+"\n");
				linha = br.readLine();
				
			}
			
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		
		}
		return lista.toString();
		
	}

	
	@RequestMapping("/brasileiros")
	public static String listaBrasileiros (){
	
        String caminho = "C:\\Users\\user\\git\\Trilha-Java-TIC18\\Semana8\\P012\\formula1\\src\\main\\resources\\pilotos.csv";
		ArrayList<String> lista = new ArrayList<String>();
		String campo = ";"; 
 		
		try(BufferedReader br = new BufferedReader(new FileReader(caminho))) {
				
			String linha = br.readLine();
			while(linha != null) {  
				String[] coluna = linha.split(campo);
				if(coluna[0].equalsIgnoreCase("brasil")) { 
				lista.add(linha);
				}
			    System.out.println("País: "+ coluna[0] + "\nPiloto: " + coluna[1] + "\nVitorias: " + coluna[2]+"\n");
				linha = br.readLine();
			    
			}
			
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		
		}
		return lista.toString();
	}
	
	@RequestMapping("/top5")
	public static List<String> top5 (){
		
        String caminho = "C:\\Users\\user\\git\\Trilha-Java-TIC18\\Semana8\\P012\\formula1\\src\\main\\resources\\pilotos.csv";
		List<String> lista = new ArrayList<String>();
		String campo = ";"; 
 		int a,b;
		
		try(BufferedReader br = new BufferedReader(new FileReader(caminho))) {
				
			String linha = br.readLine();
			while(linha != null) {  
				String[] coluna = linha.split(campo);
				lista.add(linha);
				
			    System.out.println("País: "+ coluna[0] + "\nPiloto: " + coluna[1] + "\nVitorias: " + coluna[2]+"\n");
				linha = br.readLine();
			    
			}
			
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		
		}
		return lista.subList(0, Math.min(lista.size(), 6));
	}
	
	
	@RequestMapping("/top10")
	public static List<String> top10 (){
		
        String caminho = "C:\\Users\\user\\git\\Trilha-Java-TIC18\\Semana8\\P012\\formula1\\src\\main\\resources\\pilotos.csv";
		List<String> lista = new ArrayList<String>();
		String campo = ";"; 
 			
		try(BufferedReader br = new BufferedReader(new FileReader(caminho))) {
				
			String linha = br.readLine();
			while(linha != null) {  
				String[] coluna = linha.split(campo);
				lista.add(linha);
			    System.out.println("País: "+ coluna[0] + "\nPiloto: " + coluna[1] + "\nVitorias: " + coluna[2]+"\n");
				linha = br.readLine();
			    
			}
			
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		
		}
		return lista.subList(0, Math.min(lista.size(), 11));
	}
	
}
