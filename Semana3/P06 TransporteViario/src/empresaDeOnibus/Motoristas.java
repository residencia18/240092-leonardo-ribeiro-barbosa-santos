package empresaDeOnibus;



public class Motoristas {
	
	private String nomeMotorista;
	private int cpfMotorista;
	
	




	public Motoristas() {
	}



	public Motoristas(String nomeMotorista, int cpfMotorista) {
		this.nomeMotorista = nomeMotorista;
		this.cpfMotorista = cpfMotorista;
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
