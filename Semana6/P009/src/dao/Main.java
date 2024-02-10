// Main.java
package dao;


import EmpresaEletrica.Cliente;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClienteDao clienteDAO = new ClienteDao();

        // Adicionar novo cliente
        Cliente novoCliente = new Cliente("Maria", 987654321);
        clienteDAO.adicionarCliente(novoCliente);

        // Listar todos os clientes
        System.out.println("Lista de Clientes:");
        List<Cliente> clientes = clienteDAO.listarClientes();
        for (Cliente cliente : clientes) {
            System.out.println("CPF: " + cliente.getCpf() + ", Nome: " + cliente.getNome());
        }
    }
}

