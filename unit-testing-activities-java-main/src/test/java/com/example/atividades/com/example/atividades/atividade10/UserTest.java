package com.example.atividades.atividade10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void testGetName() {
        // Arrange
        String expectedName = "John Doe";
        User user = new User(expectedName, "john.doe@example.com");

        // Act
        String actualName = user.getName();

        // Assert
        assertEquals(expectedName, actualName, "The name should be John Doe");
    }

    @Test
    public void testGetEmail() {
        // Arrange
        String expectedEmail = "john.doe@example.com";
        User user = new User("John Doe", expectedEmail);

        // Act
        String actualEmail = user.getEmail();

        // Assert
        assertEquals(expectedEmail, actualEmail, "The email should be john.doe@example.com");
    }
}
