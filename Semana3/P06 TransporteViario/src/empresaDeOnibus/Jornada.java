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
	
	public void cadastrarTrajetos() {
		Trajetos novotrajeto = new Trajetos();
		trajetos.add(novotrajeto);
		System.out.println("Trajeto cadastrado com sucesso!\n" + "No: " + novotrajeto.getNomeTrajeto() + "\nId: " + novotrajeto.getIdTrajeto());
	}

	

	
	
	public void registrarJornada(Trajetos trajeto, Motoristas motorista, Cobradores cobrador, Veiculos veiculo) {
	    if (trajeto == null || motorista == null || veiculo == null) {
	        System.out.println("Erro: Trajeto, motorista e veículo são obrigatórios para registrar uma jornada.");
	        return;
	    }

	
	    // Configura as listas da jornada existente
	    this.getTrajetos().add(trajeto);
	    this.getMotoristas().add(motorista);
	    this.getVeiculos().add(veiculo);

	    // Se o cobrador foi fornecido, adiciona à jornada existente
	    if (cobrador != null) {
	        this.getListaCobradores().add(cobrador);
	    }

	    // Exibe os dados associados à nova jornada
	    System.out.println("\n\nNova Jornada registrada:");
	    System.out.println("Trajeto: " + trajeto.getNomeTrajeto());
	    System.out.println("Motorista: " + motorista.getNomeMotorista());
	    System.out.println("Cobrador: " + (cobrador != null ? cobrador.getNomeCobrador() : "Não especificado"));
	    System.out.println("Veículo: " + veiculo.getModelo());

	    // Adicione a nova jornada à lista de jornadas, se necessário
	    // this.listaJornadas.add(novaJornada);
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




