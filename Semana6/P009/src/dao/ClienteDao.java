// ClienteDAO.java
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import EmpresaEletrica.Cliente;
import EmpresaEletrica.DatabaseUtil;

public class ClienteDao {
    private Connection connection;

    public ClienteDao() {
        try {
            connection = DatabaseUtil.getConnection(); // Obtém a conexão com o banco de dados
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para adicionar um novo cliente
    public void adicionarCliente(Cliente cliente) {
        try {
            String query = "INSERT INTO Cliente (cpf, nome) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, cliente.getCpf());
            preparedStatement.setString(2, cliente.getNome());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para listar todos os clientes
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        try {
            String query = "SELECT * FROM Cliente";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setCpf(resultSet.getInt("cpf"));
                cliente.setNome(resultSet.getString("nome"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    // Método principal para testar a classe ClienteDAO
    public static void main(String[] args) {
        ClienteDao clienteDAO = new ClienteDao();

        // Adicionar novo cliente
        Cliente novoCliente = new Cliente("João", 123456789);
        clienteDAO.adicionarCliente(novoCliente);

        // Listar todos os clientes
        List<Cliente> clientes = clienteDAO.listarClientes();
        for (Cliente cliente : clientes) {
            System.out.println("CPF: " + cliente.getCpf() + ", Nome: " + cliente.getNome());
        }
    }
}
