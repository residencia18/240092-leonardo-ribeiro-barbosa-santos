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
	private LocalDateTime inicio;
	private LocalDateTime fim;
	
	
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
	
	public void cadastrarTrajetos(String nome, int id) {
		Trajetos novotrajeto = new Trajetos(nome, id);
		trajetos.add(novotrajeto);
		System.out.println("Trajeto cadastrado com sucesso!\n" + "Nome: " + novotrajeto.getNomeTrajeto() + "\nId: " + novotrajeto.getIdTrajeto());
	}

	

	
	
	public void registrarJornada() {
	    if (listaMotoristas.isEmpty() || listaVeiculos.isEmpty() || trajetos.isEmpty()) {
	        System.out.println("Erro: Necessário cadastrar motorista, veículo e trajeto antes de registrar uma jornada.");
	        return;
	    }

	    // Pega o primeiro motorista da lista
	    Motoristas motorista = listaMotoristas.get(0);
	    System.out.println("Lista de Veículos: " + listaVeiculos);
	    // Pega o primeiro veículo da lista
	    Veiculos veiculo = listaVeiculos.get(0);

	    // Pega todos os trajetos da lista
	    Trajetos trajetosJornada = trajetos.get(0);

	    // Pega o primeiro cobrador da lista ou define como null se a lista estiver vazia
	    Cobradores cobrador = listaCobradores.isEmpty() ? null : listaCobradores.get(0);

	    inicio = LocalDateTime.now();
	    
	    // Exibe os dados associados à nova jornada
	    System.out.println("\nNova Jornada registrada:");
	    System.out.println("Motorista: " + motorista.getNomeMotorista());
	    System.out.println("Trajeto: " + trajetosJornada.getNomeTrajeto());
	    System.out.println("Veículo: " + veiculo.getModelo());
	    System.out.println("Cobrador: " + (cobrador != null ? cobrador.getNomeCobrador() : "Não especificado"));
	    System.out.println("Data e Hora de Início: " + inicio);
	    
	    fim = LocalDateTime.now();
        System.out.println("Data e Hora de Fim: " + fim);
        
        trajetosJornada.getListaJornadas().add(this);
        trajetosJornada.registrarInicioTrajeto();
	  

	    // Limpa as listas após o registro da jornada
	    listaMotoristas.clear();
	    listaCobradores.clear();
	    listaVeiculos.clear();
	    trajetos.clear();
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



	public List<Veiculos> getListaVeiculos() {
		return listaVeiculos;
	}



	public void setListaVeiculos(List<Veiculos> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}



	public LocalDateTime getInicio() {
		return inicio;
	}




	public void setInicio(LocalDateTime inicio) {
		this.inicio = inicio;
	}


	public LocalDateTime getFim() {
		return fim;
	}



	public void setFim(LocalDateTime fim) {
		this.fim = fim;
	}

	
}




