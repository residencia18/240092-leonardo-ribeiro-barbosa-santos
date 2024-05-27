package com.example.atividades.atividade08;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StatisticsTest {

    @Test
    public void testCalculateAverage() {
        // Criar uma lista de números para calcular a média
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        
        // Criar uma instância de Statistics
        Statistics statistics = new Statistics();
        
        // Calcular a média e verificar se está correta
        assertEquals(3.0, statistics.calculateAverage(numbers), 0.0001, "Average of {1, 2, 3, 4, 5} should be 3.0");
    }

    @Test
    public void testCalculateAverageWithEmptyList() {
        // Criar uma lista vazia
        List<Integer> emptyList = new ArrayList<>();
        
        // Criar uma instância de Statistics
        Statistics statistics = new Statistics();
        
        // Verificar se uma exceção é lançada ao calcular a média de uma lista vazia
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> statistics.calculateAverage(emptyList),
                "Should throw IllegalArgumentException for empty list");
        assertEquals("The list of numbers cannot be empty", exception.getMessage(),
                "Exception message should be 'The list of numbers cannot be empty'");
    }

    @Test
    public void testCalculateAverageWithNullList() {
        // Criar uma lista nula
        List<Integer> nullList = null;
        
        // Criar uma instância de Statistics
        Statistics statistics = new Statistics();
        
        // Verificar se uma exceção é lançada ao calcular a média de uma lista nula
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> statistics.calculateAverage(nullList),
                "Should throw IllegalArgumentException for null list");
        assertEquals("The list of numbers cannot be empty", exception.getMessage(),
                "Exception message should be 'The list of numbers cannot be empty'");
    }
}

