package empresaDeOnibus;

import java.util.Scanner;

public class Motoristas {
	

	private int cpfMotorista;
	private String nomeMotorista;
	
	
	
	
	public void cadastrarMotorista() {
		Scanner scanner = new Scanner(System.in);

        System.out.print("Nome do motorista: ");
        this.nomeMotorista = scanner.nextLine();

        System.out.print("CPF do motorista: ");
        this.cpfMotorista = scanner.nextInt();
        
        System.out.println("Motorista cadastrado com sucesso!\n");
        
        
        
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
