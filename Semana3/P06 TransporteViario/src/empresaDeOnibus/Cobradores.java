package empresaDeOnibus;

import java.util.Scanner;

public class Cobradores {

	private int cpfCobrador;
	private String nomeCobrador;
	
	
	public void cadastrarCobrador() {
		Scanner scanner = new Scanner(System.in);

        System.out.print("Nome do cobrador: ");
        this.nomeCobrador = scanner.nextLine();

        System.out.print("CPF do cobrador: ");
        this.cpfCobrador = scanner.nextInt();
        System.out.println("Cobrador cadastrado com sucesso!\n");
	}

	
	

	public int getCpfCobrador() {
		return cpfCobrador;
	}


	public void setCpfCobrador(int cpfCobrador) {
		this.cpfCobrador = cpfCobrador;
	}


	public String getNomeCobrador() {
		return nomeCobrador;
	}


	public void setNomeCobrador(String nomeCobrador) {
		this.nomeCobrador = nomeCobrador;
	}
	
	
}
