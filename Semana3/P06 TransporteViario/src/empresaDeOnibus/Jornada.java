package empresaDeOnibus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jornada {

	private List<Jornada> jornadas;
	private List<Cobradores> cobradores;
	private  List<Motoristas> motoristas;
	private List<Veiculos> veiculos;
	private int idJornada;
	private LocalDateTime datahora;
	
	
	public Jornada() {
		this.jornadas = new ArrayList<>();
		this.motoristas = new ArrayList<>();
		this.cobradores = new ArrayList<>();
		this.veiculos = new ArrayList<>();
	}


	public void novaJornada() {
		Scanner scanner = new Scanner(System.in);
		
		Jornada novaJornada = new Jornada();
		
		
		 novaJornada.motoristas = getMotoristas();
		 novaJornada.cobradores = getCobradores();
		 novaJornada.veiculos = getVeiculos();
		 
		 Motoristas novoMotorista = new Motoristas();
		 novoMotorista.cadastrarMotorista();
		
		 Cobradores novoCobrador = new Cobradores();
		 novoCobrador.cadastrarCobrador();
		 
		 Veiculos novoVeiculo = new Veiculos();
		 novoVeiculo.cadastrarVeiculo();
		 
		 System.out.println("Nova jornada adicionada com sucesso!" + "\n\nId: " + this.idJornada+ "\nMotorista: " + novoMotorista.getNomeMotorista() + "\nCobrador: " + novoCobrador.getNomeCobrador() + "\nVeiculo: " + novoVeiculo.getTipoVeiculo());
	
	
	

	}
	
	

	public List<Jornada> getJornadas() {
		return jornadas;
	}


	public void setJornadas(List<Jornada> jornadas) {
		this.jornadas = jornadas;
	}


	public List<Cobradores> getCobradores() {
		return cobradores;
	}


	public void setCobradores(List<Cobradores> cobradores) {
		this.cobradores = cobradores;
	}


	public List<Motoristas> getMotoristas() {
		return (List<Motoristas>) motoristas;
	}


	public void setMotoristas(Motoristas motoristas) {
		this.motoristas = (List<Motoristas>) motoristas;
	}


	public List<Veiculos> getVeiculos() {
		return veiculos;
	}


	public void setVeiculos(List<Veiculos> veiculos) {
		this.veiculos = veiculos;
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




