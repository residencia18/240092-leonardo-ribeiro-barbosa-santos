package com.example.atividades.atividade07;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DatabaseTest {

    private Connection connection;
    private Database database;

    @BeforeEach
    public void setUp() throws Exception {
        // Configura uma conexão com o banco de dados H2 em memória
        connection = DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", "sa", "");
        database = new Database(connection, "jdbc:mysql://localhost:3306/seu_banco_de_dados", "root", "12345");

        // Cria a tabela de usuários no banco de dados H2
        connection.createStatement().execute("CREATE TABLE users (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255), email VARCHAR(255))");
    }
    
    @AfterEach
    public void tearDown() throws Exception {
        // Fecha a conexão com o banco de dados
        if (connection != null) {
            connection.close();
        }
    }

    @Test
    public void testSaveUser() throws Exception {
        // Cria um usuário de teste
        User user = new User("João", "joao@example.com");

        // Chama o método saveUser() para salvar o usuário no banco de dados
        database.saveUser(user);

        // Verifica se o usuário foi salvo corretamente
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE name = ?");
        statement.setString(1, user.getName());
        ResultSet resultSet = statement.executeQuery();
        assertTrue(resultSet.next());
        assertEquals(user.getEmail(), resultSet.getString("email"));
    }
}
