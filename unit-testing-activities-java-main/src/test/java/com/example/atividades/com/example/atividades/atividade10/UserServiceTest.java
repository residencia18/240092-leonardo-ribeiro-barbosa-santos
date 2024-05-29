package com.example.atividades.atividade10;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UserServiceTest {

    @Test
    public void testGetUserInfo_ValidUserId() {
        // Arrange
        UserService userService = new UserService();
        int userId = 123;

        // Act
        User user = userService.getUserInfo(userId);

        // Assert
        assertNull(user, "User should be null as it's a mock implementation");
    }

    @Test
    public void testGetUserInfo_InvalidUserId() {
        // Arrange
        UserService userService = new UserService();
        int invalidUserId = -1;

        // Act
        User user = userService.getUserInfo(invalidUserId);

        // Assert
        assertNull(user, "User should be null for invalid user ID");
    }
}
