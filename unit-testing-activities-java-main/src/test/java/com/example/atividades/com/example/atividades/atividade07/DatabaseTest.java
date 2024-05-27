package com.example.atividades.atividade07;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


public class DatabaseTest {
    
    private Database database;
    
    @BeforeEach
    public void setUp() {
        // Inicializar o objeto Database antes de cada teste
        database = new Database();
    }
    
    @Test
    public void testSaveUser() {
        // Criar um usuário para salvar no banco de dados
        User user = new User("John Doe", "john@example.com");
        
        // Testar se o método saveUser salva o usuário corretamente
        assertDoesNotThrow(() -> database.saveUser(user), "Should not throw any exceptions when saving user");
        
        // Potencialmente, você pode adicionar mais asserções aqui para verificar se o usuário foi salvo corretamente no banco de dados
    }
}

