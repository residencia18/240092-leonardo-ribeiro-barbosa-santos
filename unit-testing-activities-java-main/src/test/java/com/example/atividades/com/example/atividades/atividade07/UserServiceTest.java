package com.example.atividades.atividade07;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;


public class UserServiceTest {

    @Test
    public void testSaveUser() {
        // Criar um usuário válido para salvar
        User validUser = new User("John Doe", "john@example.com");
        
        // Criar um mock para a classe Database
        Database databaseMock = mock(Database.class);
        
        // Criar uma instância de UserService com o mock de Database
        UserService userService = new UserService(databaseMock);
        
        // Chamar o método saveUser com o usuário válido
        assertDoesNotThrow(() -> userService.saveUser(validUser), "Should not throw any exceptions when saving valid user");
        
        // Verificar se o método saveUser da classe Database foi chamado corretamente
        verify(databaseMock).saveUser(validUser);
    }
    
    @Test
    public void testSaveUserWithNullName() {
        // Criar um usuário com nome nulo
        User userWithNullName = new User(null, "john@example.com");
        
        // Criar um mock para a classe Database
        Database databaseMock = mock(Database.class);
        
        // Criar uma instância de UserService com o mock de Database
        UserService userService = new UserService(databaseMock);
        
        // Verificar se uma exceção é lançada ao tentar salvar um usuário com nome nulo
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> userService.saveUser(userWithNullName), "Should throw IllegalArgumentException for user with null name");
        assertEquals("User must have a name and email", exception.getMessage(), "Exception message should be User must have a name and email");
        
        // Verificar se o método saveUser da classe Database não foi chamado
        verify(databaseMock, never()).saveUser(userWithNullName);
    }
    
    @Test
    public void testSaveUserWithEmptyName() {
        // Criar um usuário com nome vazio
        User userWithEmptyName = new User("", "john@example.com");
        
        // Criar um mock para a classe Database
        Database databaseMock = mock(Database.class);
        
        // Criar uma instância de UserService com o mock de Database
        UserService userService = new UserService(databaseMock);
        
        // Verificar se uma exceção é lançada ao tentar salvar um usuário com nome vazio
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> userService.saveUser(userWithEmptyName), "Should throw IllegalArgumentException for user with empty name");
        assertEquals("User must have a name and email", exception.getMessage(), "Exception message should be User must have a name and email");
        
        // Verificar se o método saveUser da classe Database não foi chamado
        verify(databaseMock, never()).saveUser(userWithEmptyName);
    }
    
    @Test
    public void testSaveUserWithNullEmail() {
        // Criar um usuário com e-mail nulo
        User userWithNullEmail = new User("John Doe", null);
        
        // Criar um mock para a classe Database
        Database databaseMock = mock(Database.class);
        
        // Criar uma instância de UserService com o mock de Database
        UserService userService = new UserService(databaseMock);
        
        // Verificar se uma exceção é lançada ao tentar salvar um usuário com e-mail nulo
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> userService.saveUser(userWithNullEmail), "Should throw IllegalArgumentException for user with null email");
        assertEquals("User must have a name and email", exception.getMessage(), "Exception message should be User must have a name and email");
        
        // Verificar se o método saveUser da classe Database não foi chamado
        verify(databaseMock, never()).saveUser(userWithNullEmail);
    }
    
    @Test
    public void testSaveUserWithEmptyEmail() {
        // Criar um usuário com e-mail vazio
        User userWithEmptyEmail = new User("John Doe", "");
        
        // Criar um mock para a classe Database
        Database databaseMock = mock(Database.class);
        
        // Criar uma instância de UserService com o mock de Database
        UserService userService = new UserService(databaseMock);
        
        // Verificar se uma exceção é lançada ao tentar salvar um usuário com e-mail vazio
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> userService.saveUser(userWithEmptyEmail), "Should throw IllegalArgumentException for user with empty email");
        assertEquals("User must have a name and email", exception.getMessage(), "Exception message should be User must have a name and email");
        
        // Verificar se o método saveUser da classe Database não foi chamado
        verify(databaseMock, never()).saveUser(userWithEmptyEmail);
    }
}
