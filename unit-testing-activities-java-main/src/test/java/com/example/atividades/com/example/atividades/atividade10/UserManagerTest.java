package com.example.atividades.atividade10;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

public class UserManagerTest {

    @Test
    public void testFetchUserInfo_UserFound() {
        // Arrange
        UserService userService = mock(UserService.class);
        UserManager userManager = new UserManager(userService);
        int userId = 123;
        User expectedUser = new User("John Doe", "john.doe@example.com");
        when(userService.getUserInfo(userId)).thenReturn(expectedUser);

        // Act
        User actualUser = userManager.fetchUserInfo(userId);

        // Assert
        assertEquals(expectedUser, actualUser, "The user info should match");
    }

    @Test
    public void testFetchUserInfo_UserNotFound() {
        // Arrange
        UserService userService = mock(UserService.class);
        UserManager userManager = new UserManager(userService);
        int userId = 123;
        when(userService.getUserInfo(userId)).thenReturn(null);

        // Act & Assert
        assertThrows(RuntimeException.class, () -> {
            userManager.fetchUserInfo(userId);
        }, "User not found");
    }
}
