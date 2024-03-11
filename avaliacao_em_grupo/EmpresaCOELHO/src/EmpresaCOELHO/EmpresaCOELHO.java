package EmpresaCOELHO;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EmpresaCOELHO {
	private ArrayList<Cliente> clientes;
    private ArrayList<Imovel> imoveis;
    private ArrayList<Fatura> faturas;
    private ArrayList<Pagamento> pagamentos;
    private ArrayList<Falha> falhas;
    private ArrayList<Reparo> reparos;

    public EmpresaCOELHO() {
        clientes = new ArrayList<>();
        imoveis = new ArrayList<>();
        faturas = new ArrayList<>();
        pagamentos = new ArrayList<>();
        falhas = new ArrayList<>();
        reparos = new ArrayList<>();
    }
    
	public static void main(String[] args) {
		EmpresaCOELHO sistema = new EmpresaCOELHO();
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        do {
            // Menu Principal
            System.out.println("=== MENU ===");
            System.out.println("1. Gestão de Clientes");
            System.out.println("2. Gestão de Imóveis");
            System.out.println("3. Gestão de Faturas");
            System.out.println("4. Gestão de Pagamentos");
            System.out.println("5. Gestão de Falhas");
            System.out.println("6. Gestão de Reparos");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                
                try {
                    //System.out.print("Escolha uma opção: ");
                	//opcao = scanner.nextInt();
                	scanner.nextLine(); 
                } catch (InputMismatchException e) {
                    System.out.println("Por favor, insira um número.");
                    opcao = 0; // Define uma opção inválida para evitar problemas
                    scanner.nextLine(); // Limpa o buffer do Scanner
                }

                switch (opcao) {
                    case 1:
                        sistema.gestaoClientes();
                        break;
                    case 2:
                        sistema.gestaoImoveis();
                        break;
                    case 3:
                        sistema.gestaoFaturas();
                        break;
                    case 4:
                    	sistema.gestaoPagamentos();
                        break;
                    case 5:
                        sistema.gestaoFalhas();
                        break;
                    case 6:
                    	sistema.gestaoReparos();
                        break;
                    case 7:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            } else {
                System.out.println("Por favor, insira um número.");
                scanner.nextLine(); // Limpar o buffer do scanner
            }
        } while (opcao != 7);

        scanner.close();

	}
	
	public void gestaoClientes() {
        Scanner scanner = new Scanner(System.in);
        int opcaoCliente;

        do {
            // Menu Gestão de Clientes
            System.out.println("=== GESTÃO DE CLIENTES ===");
            System.out.println("1. Incluir Cliente");
            System.out.println("2. Consultar Cliente");
            System.out.println("3. Listar Clientes");
            System.out.println("4. Excluir Cliente");
            System.out.println("5. Alterar Cliente");
            System.out.println("6. Voltar");
            System.out.print("Escolha uma opção: ");
            
            opcaoCliente = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcaoCliente) {
                case 1:
                    incluirCliente();
                    break;
                case 2:
                    consultarCliente();
                    break;
                case 3:
                    listarClientes();
                    break;
                case 4:
                    excluirCliente();
                    break;
                case 5:
                    alterarCliente();
                    break;
                case 6:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcaoCliente != 6);

        scanner.close();
    }

    private void incluirCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o nome do cliente:");
        String nome = scanner.nextLine();
        System.out.println("Informe o CPF do cliente:");
        String cpf = scanner.nextLine();

        clientes.add(new Cliente(nome, cpf));
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private void consultarCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o CPF do cliente:");
        String cpf = scanner.nextLine();

        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                System.out.println("Cliente encontrado:");
                System.out.println(cliente);
                return;
            }
        }

        System.out.println("Cliente não encontrado!");
    }

    private void listarClientes() {
        System.out.println("=== LISTA DE CLIENTES ===");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    private void excluirCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o CPF do cliente a ser excluído:");
        String cpf = scanner.nextLine();

        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                clientes.remove(cliente);
                System.out.println("Cliente excluído com sucesso!");
                return;
            }
        }

        System.out.println("Cliente não encontrado!");
    }

    private void alterarCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o CPF do cliente a ser alterado:");
        String cpf = scanner.nextLine();

        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                System.out.println("Informe o novo nome do cliente:");
                String novoNome = scanner.nextLine();
                cliente.setNome(novoNome);
                System.out.println("Cliente alterado com sucesso!");
                return;
            }
        }

        System.out.println("Cliente não encontrado!");
    }
    
    public void gestaoImoveis() {
        Scanner scanner = new Scanner(System.in);
        int opcaoImovel;

        do {
            System.out.println("=== GESTÃO DE IMÓVEIS ===");
            System.out.println("1. Incluir Imóvel");
            System.out.println("2. Consultar Imóvel");
            System.out.println("3. Listar Imóveis");
            System.out.println("4. Excluir Imóvel");
            System.out.println("5. Alterar Imóvel");
            System.out.println("6. Voltar");
            System.out.print("Escolha uma opção: ");
            opcaoImovel = scanner.nextInt();

            switch (opcaoImovel) {
                case 1:
                    incluirImovel(scanner);
                    break;
                case 2:
                    consultarImovel(scanner);
                    break;
                case 3:
                    listarImoveis();
                    break;
                case 4:
                    excluirImovel(scanner);
                    break;
                case 5:
                    alterarImovel(scanner);
                    break;
                case 6:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcaoImovel != 6);
    }
    private void incluirImovel(Scanner scanner) {
        System.out.println("Digite o endereço do imóvel:");
        scanner.nextLine(); // Limpar o buffer
        String endereco = scanner.nextLine();

        // Lógica para criar um novo imóvel e adicionar à lista
        Imovel novoImovel = new Imovel(endereco, 0, 0, endereco);
        imoveis.add(novoImovel);
        System.out.println("Imóvel adicionado com sucesso!");
    }

    private void consultarImovel(Scanner scanner) {
        System.out.println("Digite o endereço do imóvel:");
        scanner.nextLine(); // Limpar o buffer
        String endereco = scanner.nextLine();

        // Buscar e exibir os detalhes do imóvel (caso exista na lista)
        for (Imovel imovel : imoveis) {
            if (imovel.getEndereco().equals(endereco)) {
                System.out.println("Endereço: " + imovel.getEndereco());
                return;
            }
        }
        System.out.println("Imóvel não encontrado!");
    }

    private void listarImoveis() {
        // Listar todos os imóveis cadastrados
        if (imoveis.isEmpty()) {
            System.out.println("Não há imóveis cadastrados.");
        } else {
            System.out.println("=== LISTA DE IMÓVEIS ===");
            for (Imovel imovel : imoveis) {
                System.out.println("Endereço: " + imovel.getEndereco());
            }
        }
    }

    private void excluirImovel(Scanner scanner) {
        System.out.println("Digite o endereço do imóvel a ser excluído:");
        scanner.nextLine(); // Limpar o buffer
        String endereco = scanner.nextLine();

        // Remover o imóvel (caso exista na lista)
        Imovel imovelParaRemover = null;
        for (Imovel imovel : imoveis) {
            if (imovel.getEndereco().equals(endereco)) {
                imovelParaRemover = imovel;
                break;
            }
        }
        if (imovelParaRemover != null) {
            imoveis.remove(imovelParaRemover);
            System.out.println("Imóvel removido com sucesso!");
        } else {
            System.out.println("Imóvel não encontrado!");
        }
    }

    private void alterarImovel(Scanner scanner) {
        System.out.println("Digite o endereço do imóvel a ser alterado:");
        scanner.nextLine(); // Limpar o buffer
        String endereco = scanner.nextLine();

        // Modificar os detalhes do imóvel (caso exista na lista)
        for (Imovel imovel : imoveis) {
            if (imovel.getEndereco().equals(endereco)) {
                System.out.println("Digite o novo endereço:");
                String novoEndereco = scanner.nextLine();
                imovel.setEndereco(novoEndereco);
                System.out.println("Endereço do imóvel alterado com sucesso!");
                return;
            }
        }
    


        System.out.println("Imóvel não encontrado!");
    }
    public void gestaoFaturas() {
        Scanner scanner = new Scanner(System.in);
        int opcaoFatura;

        do {
            System.out.println("=== GESTÃO DE FATURAS ===");
            System.out.println("1. Registrar Consumo");
            System.out.println("2. Listar Faturas Abertas");
            System.out.println("3. Listar Todas as Faturas");
            System.out.println("4. Voltar");
            System.out.print("Escolha uma opção: ");
            opcaoFatura = scanner.nextInt();

            switch (opcaoFatura) {
                case 1:
                    registrarConsumo(scanner);
                    break;
                case 2:
                    listarFaturasAbertas();
                    break;
                case 3:
                    listarTodasFaturas();
                    break;
                case 4:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcaoFatura != 4);
    }

    private void registrarConsumo(Scanner scanner) {
        System.out.println("Digite a matrícula do imóvel:");
        String matricula = scanner.next();

        Imovel imovel = buscarImovelPorMatricula(matricula);
        if (imovel != null) {
            System.out.println("Digite o valor da última leitura:");
            double ultimaLeitura = scanner.nextDouble();

            // Lógica para registrar o consumo e criar a fatura
            Fatura novaFatura = new Fatura(imovel, ultimaLeitura);
            faturas.add(novaFatura);
            System.out.println("Consumo registrado e fatura gerada com sucesso!");
        } else {
            System.out.println("Imóvel não encontrado!");
        }
    }

    private void listarFaturasAbertas() {
        System.out.println("=== FATURAS EM ABERTO ===");
        for (Fatura fatura : faturas) {
            if (!fatura.isQuitada()) {
                System.out.println(fatura);
            }
        }
    }

    private void listarTodasFaturas() {
        System.out.println("=== TODAS AS FATURAS ===");
        for (Fatura fatura : faturas) {
            System.out.println(fatura);
        }
    }

    private Imovel buscarImovelPorMatricula(String matricula) {
        for (Imovel imovel : imoveis) {
            if (imovel.getMatricula().equals(matricula)) {
                return imovel;
            }
        }
        return null;
    }


    
    public void gestaoPagamentos() {
        Scanner scanner = new Scanner(System.in);
        int opcaoPagamento;

        do {
            System.out.println("=== GESTÃO DE PAGAMENTOS ===");
            System.out.println("1. Incluir Pagamento");
            System.out.println("2. Listar Todos os Pagamentos");
            System.out.println("3. Listar Todos os Reembolsos");
            System.out.println("4. Voltar");
            System.out.print("Escolha uma opção: ");
            opcaoPagamento = scanner.nextInt();

            switch (opcaoPagamento) {
                case 1:
                    incluirPagamento(scanner);
                    break;
                case 2:
                    listarTodosPagamentos();
                    break;
                case 3:
                    listarTodosReembolsos();
                    break;
                case 4:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcaoPagamento != 4);
    }

    private void incluirPagamento(Scanner scanner) {
        System.out.println("Digite o número da fatura associada ao pagamento:");
        int numeroFatura = scanner.nextInt();

        Fatura fatura = buscarFaturaPorNumero(numeroFatura);
        if (fatura != null && !fatura.isQuitada()) {
            System.out.println("Digite o valor do pagamento:");
            double valorPagamento = scanner.nextDouble();

            // Lógica para incluir pagamento
            Pagamento novoPagamento = new Pagamento(fatura.getMatriculaImovel(), valorPagamento);
            fatura.registrarPagamento(novoPagamento);
            pagamentos.add(novoPagamento);

            if (fatura.getValorCalculado() <= 0) {
                fatura.setEstaQuitada(true);
                System.out.println("Fatura quitada!");
            } else {
                System.out.println("Pagamento registrado com sucesso!");
            }
        } else {
            System.out.println("Fatura não encontrada ou já quitada!");
        }
    }

    private void listarTodosPagamentos() {
        System.out.println("=== TODOS OS PAGAMENTOS ===");
        for (Pagamento pagamento : pagamentos) {
            if (!pagamento.isReembolso()) {
                System.out.println(pagamento);
            }
        }
    }

    private void listarTodosReembolsos() {
        System.out.println("=== TODOS OS REEMBOLSOS ===");
        for (Pagamento pagamento : pagamentos) {
            if (pagamento.isReembolso()) {
                System.out.println(pagamento);
            }
        }
    }

    private Fatura buscarFaturaPorNumero(int numeroFatura) {
        // Lógica para buscar a fatura pelo número
        return null;
    }

    
	public void gestaoFalhas() {
	    Scanner scanner = new Scanner(System.in);
	    int opcaoFalha;
	
	    do {
	        System.out.println("=== GESTÃO DE FALHAS ===");
	        System.out.println("1. Incluir Falha");
	        System.out.println("2. Voltar");
	        System.out.print("Escolha uma opção: ");
	        opcaoFalha = scanner.nextInt();
	
	        switch (opcaoFalha) {
	            case 1:
	                incluirFalha(scanner);
	                break;
	            case 2:
	                System.out.println("Voltando ao Menu Principal...");
	                break;
	            default:
	                System.out.println("Opção inválida!");
	                break;
	        }
	    } while (opcaoFalha != 2);
	}

	private void incluirFalha(Scanner scanner) {
	    System.out.println("Digite o tipo de falha (Geração ou Distribuição):");
	    String tipoFalha = scanner.next();
	    scanner.nextLine(); // Limpar o buffer
	    System.out.println("Digite a descrição da falha:");
	    String descricao = scanner.nextLine();
	    System.out.println("Digite a matricula do imovel:");
	    String MatriculaImovel = scanner.nextLine();
	  
	
	    // Lógica para incluir a falha
	    Falha novaFalha = new Falha(tipoFalha, descricao, true, MatriculaImovel) ;
	    falhas.add(novaFalha);
	
	    if (tipoFalha.equalsIgnoreCase("Distribuição")) {
	        novaFalha.isReportadaPorCliente();
	    }
	
	    System.out.println("Falha registrada com sucesso!");
	}


	
	

	
	public void gestaoReparos() {
	    Scanner scanner = new Scanner(System.in);
	    int opcaoReparo;
	
	    do {
	        System.out.println("=== GESTÃO DE REPAROS ===");
	        System.out.println("1. Listar Reparos em Aberto");
	        System.out.println("2. Encerrar Reparo");
	        System.out.println("3. Voltar");
	        System.out.print("Escolha uma opção: ");
	        opcaoReparo = scanner.nextInt();
	
	        switch (opcaoReparo) {
	            case 1:
	                listarReparosAbertos();
	                break;
	            case 2:
	                encerrarReparo(scanner);
	                break;
	            case 3:
	                System.out.println("Voltando ao Menu Principal...");
	                break;
	            default:
	                System.out.println("Opção inválida!");
	                break;
	        }
	    } while (opcaoReparo != 3);
	}
	
	private Reparo buscarReparoPorId(int idReparo) {
	    for (Reparo reparo : reparos) {
	        if (reparo.getId() == idReparo) {
	            return reparo;
	        }
	    }
	    return null;
	}
	
	private void encerrarReparo(Scanner scanner) {
	    System.out.println("Digite o ID do reparo a ser encerrado:");
	    int idReparo = scanner.nextInt();
	
	    Reparo reparo = buscarReparoPorId(idReparo);
	    if (reparo != null && !reparo.isConcluido()) {
	        System.out.println("O reparo resolveu a falha? (s/n)");
	        String resolveu = scanner.next();
	
	        if (resolveu.equalsIgnoreCase("s")) {
	            reparo.setConcluido(true);
	            reparo.setDataFinalizacao("data atual"); // Defina a data atual do sistema aqui
	            System.out.println("Reparo encerrado com sucesso!");
	        } else {
	            iniciarNovoReparo(reparo, scanner);
	        }
	    } else {
	        System.out.println("Reparo não encontrado ou já encerrado!");
	    }
	}

	private void iniciarNovoReparo(Reparo reparoAnterior, Scanner scanner) {
	    System.out.println("Digite a descrição do novo reparo:");
	    String descricao = scanner.next();
	    
	    Reparo novoReparo = new Reparo(reparoAnterior.getFalhaAssociada(), descricao, "dataInicio");
	    reparos.add(novoReparo);

	    System.out.println("Novo reparo iniciado com sucesso!");
	}


	public void listarReparosAbertos() {
	    System.out.println("=== REPAROS EM ABERTO ===");
	    for (Reparo reparo : reparos) {
	        if (!reparo.isConcluido()) {
	            System.out.println(reparo);
	        }
	    }
	}

}
