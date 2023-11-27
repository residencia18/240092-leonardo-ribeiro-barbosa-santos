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
	public Sessao() {}
	
	private Date dataHoraInicio;
	private Date dataHoraFim;
	private boolean ativo = false;
	private Usuario usuario;

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Usuario getUsuario() {
		return this.usuario;
	}
	
	public void ativarSessao() {
		this.ativo = true;
	}
	
	public void desativarSessao() {
		this.ativo = false;
	}
	

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

	public boolean logar(ArrayList<Usuario> listaDeUsuarios) {
		Scanner scan = new java.util.Scanner(System.in);
		System.out.println("Digite seu usuário:\n");
		String user = scan.nextLine();
		System.out.println("Digite sua senha:\n");
		String pass = scan.nextLine();
		
		Sessao sessao = new Sessao();

		for (int i = 0; i < listaDeUsuarios.size(); i++) {
			if (user.equals(listaDeUsuarios.get(i).getEmail()) && pass.equals(listaDeUsuarios.get(i).getSenha())) {
				sessao.ativarSessao();
				sessao.setDataHoraInicio(new Date());
				setUsuario(listaDeUsuarios.get(i));
				scan.close();
				return true;
			}
		}
		
		scan.close();
		return false;
	}
	
		
	public void deslogar(Sessao sessao) {
		sessao.desativarSessao();
		sessao.setDataHoraFim(new Date());
	}

	public boolean isAtivo() {
		return this.ativo;
	}

	public Boolean solicitarAutenticacao(ArrayList<Usuario> listaDeUsuarios) {
		Scanner scan = new java.util.Scanner(System.in);
		System.out.println("Digite seu usuário:\n");
		String user = scan.nextLine();
		System.out.println("Digite sua senha:\n");
		String pass = scan.nextLine();
		
		Sessao sessao = new Sessao();

		for (int i = 0; i < listaDeUsuarios.size(); i++) {
			if (user.equals(listaDeUsuarios.get(i).getEmail()) && pass.equals(listaDeUsuarios.get(i).getSenha())) {
				sessao.ativarSessao();
				sessao.setDataHoraInicio(new Date());
				setUsuario(listaDeUsuarios.get(i));
				scan.close();
				return true;
			}
		}
		
		scan.close();
		return false;
	}

	public void criarAmizade(Usuario user1, Usuario user2){
		user1.setAmizade(user2);

	}

	public Boolean defazerAmizade(Usuario user1, Usuario user2){
		for (int i = 0; i < user1.getListaAmizade().size(); i++) {
			
			if(user2.equals(user1.getListaAmizade().get(i))){
				user1.getListaAmizade().remove(i);
				return true;
			}
		}
		return false;

	}

	public void criarPostagem(Usuario usuario){
		Scanner scan = new java.util.Scanner(System.in);
		System.out.println("Digite sua postagem:\n");
		String user = scan.nextLine();
		usuario.setPostagem(user);
		scan.close();
	}

	public void listarPostagem(Usuario usuario){
		for (int i = 0; i < usuario.getListaDEPostagens().size(); i++) {
			System.out.println("Postagem: " + usuario.getListaDEPostagens().get(i));
		}
	}

	public static void main(String[] args) {
		
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		Sessao sessao = new Sessao();
		
		Scanner scan = new Scanner(System.in);
        int opcao = 0;
        
        while (opcao != 4) {
            System.out.println("Menu:");
            System.out.println("1. Logar");
            System.out.println("2. Finalizar sessao");
            System.out.println("3. Listar postagens");
			System.out.println("4. Fazer postagem");
            System.out.println("5. Sair");
            System.out.println("Escolha uma opcao: ");
            opcao = scan.nextInt();
            
            switch (opcao) {
                case 1:
                	sessao.logar(usuarios);
                    break;
                case 2:
                	sessao.deslogar(sessao);
                    break;
                case 3:
                	sessao.listarPostagem(sessao.getUsuario());
                    break;

				case 4:
					sessao.criarPostagem(sessao.getUsuario());
                case 5:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opcao invalida! Tente novamente.");
                    break;
            }
        }
        
        scan.close();

	}

}
