package RedeSocial;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Sessao {
	
	public Sessao(Date dataHoraInicio, Date dataHoraFim) {
		super();
		this.dataHoraInicio = dataHoraInicio;
		this.dataHoraFim = dataHoraFim;
	}
	
	private Date dataHoraInicio;
	private Date dataHoraFim;
	
	public Sessao() {}

	public Date getDataHoraInicio() {
		return dataHoraInicio;
	}

	public void setDataHoraInicio(Date dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
	}

	public Date getDataHoraFim() {
		return dataHoraFim;
	}

	public void setDataHoraFim(Date dataHoraFim) {
		this.dataHoraFim = dataHoraFim;
	}

	public boolean autenticar(ArrayList<Usuario> listaDeUsuarios) {
		Scanner scan = new java.util.Scanner(System.in);
		System.out.println("Digite seu usuário:\n");
		String user = scan.nextLine();
		System.out.println("Digite sua senha:\n");
		String pass = scan.nextLine();

		for (int i = 0; i < listaDeUsuarios.size(); i++) {
			if (user.equals(listaDeUsuarios.get(i).getEmail()) && pass.equals(listaDeUsuarios.get(i).getSenha())) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
