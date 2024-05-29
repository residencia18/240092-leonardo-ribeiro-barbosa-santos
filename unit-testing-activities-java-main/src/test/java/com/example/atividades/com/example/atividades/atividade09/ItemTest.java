package com.example.atividades.atividade09;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ItemTest {

	 @Test
	    public void testGetName() {
	        // Arrange
	        String expectedName = "ExampleItem";
	        Item item = new Item(expectedName);

	        // Act
	        String actualName = item.getName();

	        // Assert
	        assertEquals(expectedName, actualName);
	    }
}
