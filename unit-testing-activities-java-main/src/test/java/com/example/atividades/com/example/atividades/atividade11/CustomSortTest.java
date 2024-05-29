package com.example.atividades.atividade11;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomSortTest {

    @Test
    public void testCustomSort() {
        // Arrange
        CustomSort customSort = new CustomSort();
        List<Integer> numbers = Arrays.asList(5, 3, 8, 1, 2);

        // Act
        List<Integer> sortedNumbers = customSort.customSort(numbers);

        // Assert
        assertEquals(Arrays.asList(8, 5, 3, 2, 1), sortedNumbers, "Numbers should be sorted in descending order");
    }
}
