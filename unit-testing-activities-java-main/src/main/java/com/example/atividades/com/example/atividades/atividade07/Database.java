package com.example.atividades.atividade07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {
	
	 private Connection connection;
	
	
    public Database(Connection connection2,String url, String username, String password) throws SQLException {
        // Cria uma conexão com o banco de dados usando os argumentos fornecidos
        this.setConnection(DriverManager.getConnection(url, username, password));
    }
    
    
	public void saveUser(User user) {
        // Configurações do banco de dados
        String url = "jdbc:mysql://localhost:3306/seu_banco_de_dados";
        String username = "root";
        String password = "12345";

        // Query SQL para inserir um usuário
        String query = "INSERT INTO users (nome, email) VALUES (?, ?)";

        try (
            // Cria uma conexão com o banco de dados
            Connection connection = DriverManager.getConnection(url, username, password);
            // Cria uma instrução preparada para executar a query SQL
            PreparedStatement statement = connection.prepareStatement(query);
        ) {
            // Define os parâmetros da query com os valores do usuário
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());

            // Executa a query para inserir o usuário no banco de dados
            statement.executeUpdate();
            
            System.out.println("Usuário salvo com sucesso no banco de dados.");
        } catch (SQLException e) {
            System.err.println("Erro ao salvar usuário no banco de dados: " + e.getMessage());
        }
    }

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}
