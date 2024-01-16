package empresaDeOnibus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jornada {

	private List<Trajetos> trajetos;
	private List<Cobradores> listaCobradores;
	private  List<Motoristas> listaMotoristas;
	private List<Veiculos> listaVeiculos;
	private int idJornada;
	private LocalDateTime datahora;
	
	
	public Jornada() {
		this.listaMotoristas = new ArrayList<>();
		this.listaCobradores = new ArrayList<>();
		this.listaVeiculos = new ArrayList<>();
		this.trajetos = new ArrayList<>();
	}
	
	
	
	
	




	











	public void cadastrarMotorista(String nome, int cpf) {
	    Motoristas novoMotorista = new Motoristas(nome, cpf);
	    listaMotoristas.add(novoMotorista);
	    System.out.println("Motorista cadastrado com sucesso!\n" + "Nome: "+ novoMotorista.getNomeMotorista() + "\nCPF: " + novoMotorista.getCpfMotorista());
	    
	}
	
	public void cadastrarCobrador(String nome, int cpf) {
		Cobradores novoCobrador = new Cobradores(nome, cpf);
		listaCobradores.add(novoCobrador);
		System.out.println("Cobrador cadastrado com sucesso!\n" + "Nome: " + novoCobrador.getNomeCobrador() + "\nCPF: " + novoCobrador.getCpfCobrador());
	}

	
	public void cadastrarVeiculo(String modelo, String placa) {
		 Veiculos novoVeiculo = new Veiculos(modelo, placa); 
	        listaVeiculos.add(novoVeiculo);
	        System.out.println("Veículo cadastrado com sucesso!\nModelo do Veículo: " + novoVeiculo.getModelo() + "\nPlaca: " + novoVeiculo.getPlaca());
	}

	
	
	

	
	
	
	
	

	
	
	
	
	
	
	
	
	
	public List<Trajetos> getTrajetos() {
		return trajetos;
	}


	public void setTrajetos(List<Trajetos> trajetos) {
		this.trajetos = trajetos;
	}


	public void setMotoristas(List<Motoristas> motoristas) {
		this.listaMotoristas = motoristas;
	}


	


	public List<Cobradores> getListaCobradores() {
		return listaCobradores;
	}




	public void setListaCobradores(List<Cobradores> listaCobradores) {
		this.listaCobradores = listaCobradores;
	}




	public List<Motoristas> getListaMotoristas() {
		return listaMotoristas;
	}




	public void setListaMotoristas(List<Motoristas> listaMotoristas) {
		this.listaMotoristas = listaMotoristas;
	}




	public List<Motoristas> getMotoristas() {
		return (List<Motoristas>) listaMotoristas;
	}


	public void setMotoristas(Motoristas motoristas) {
		this.listaMotoristas = (List<Motoristas>) motoristas;
	}


	public List<Veiculos> getVeiculos() {
		return listaVeiculos;
	}


	public void setVeiculos(List<Veiculos> veiculos) {
		this.listaVeiculos = veiculos;
	}


	public int getIdJornada() {
		return idJornada;
	}


	public void setIdJornada(int idJornada) {
		this.idJornada = idJornada;
	}


	public LocalDateTime getDatahora() {
		return datahora;
	}


	public void setDatahora(LocalDateTime datahora) {
		this.datahora = datahora;
	}
	
	
	
	
}




