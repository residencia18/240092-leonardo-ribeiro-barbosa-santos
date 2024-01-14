package empresaDeOnibus;

import java.util.Scanner;

public class Veiculos {
	
	private int qtdPoltronas;
	private String tipoVeiculo;
	private String placa;
	
	
	
	public void cadastrarVeiculo() {
		Scanner scanner = new Scanner(System.in);

        System.out.print("Tipo de veiculo: ");
        this.tipoVeiculo = scanner.nextLine();

        System.out.print("Placa do veiculo: ");
        this.placa = scanner.nextLine();
        
        System.out.print("Quantidade de Poltronas: ");
        this.qtdPoltronas = scanner.nextInt();
        System.out.println("Veiculo cadastrado com sucesso!\n");
	}



	public int getQtdPoltronas() {
		return qtdPoltronas;
	}



	public void setQtdPoltronas(int qtdPoltronas) {
		this.qtdPoltronas = qtdPoltronas;
	}



	public String getTipoVeiculo() {
		return tipoVeiculo;
	}



	public void setTipoVeiculo(String tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}



	public String getPlaca() {
		return placa;
	}



	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
}
