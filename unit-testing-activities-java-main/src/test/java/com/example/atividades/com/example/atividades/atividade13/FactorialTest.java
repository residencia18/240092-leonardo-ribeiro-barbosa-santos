package com.example.atividades.atividade13;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactorialTest {

    @Test
    public void testCalculate_PositiveNumber() {
        // Arrange
        Factorial factorial = new Factorial();
        int n = 5;

        // Act
        int result = factorial.calculate(n);

        // Assert
        assertEquals(120, result, "Factorial of 5 should be 120");
    }

    @Test
    public void testCalculate_Zero() {
        // Arrange
        Factorial factorial = new Factorial();
        int n = 0;

        // Act
        int result = factorial.calculate(n);

        // Assert
        assertEquals(1, result, "Factorial of 0 should be 1");
    }

    @Test
    public void testCalculate_NegativeNumber() {
        // Arrange
        Factorial factorial = new Factorial();
        int n = -5;

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            factorial.calculate(n);
        });
        assertEquals("Number must be non-negative", exception.getMessage(), "Exception message should be correct");
    }
}
