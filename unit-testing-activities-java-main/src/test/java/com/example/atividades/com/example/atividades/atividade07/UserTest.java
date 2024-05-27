package com.example.atividades.atividade07;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void testGetName() {
        // Criar um usuário com nome "John Doe" e e-mail "john@example.com"
        User user = new User("John Doe", "john@example.com");
        
        // Verificar se o método getName retorna o nome correto
        assertEquals("John Doe", user.getName(), "Name should be John Doe");
    }
    
    @Test
    public void testGetEmail() {
        // Criar um usuário com nome "John Doe" e e-mail "john@example.com"
        User user = new User("John Doe", "john@example.com");
        
        // Verificar se o método getEmail retorna o e-mail correto
        assertEquals("john@example.com", user.getEmail(), "Email should be john@example.com");
    }
}

