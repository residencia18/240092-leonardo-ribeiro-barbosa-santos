package com.example.atividades.atividade09;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class ItemCollectionTest {
    private ItemCollection itemCollection;
    private Item item1;
    private Item item2;

    @BeforeEach
    public void setUp() {
        itemCollection = new ItemCollection();
        item1 = new Item("Item1");
        item2 = new Item("Item2");
    }

    @Test
    public void testAddItem() {
        // Arrange
        int initialSize = itemCollection.getItems().size();

        // Act
        itemCollection.addItem(item1);

        // Assert
        assertEquals(initialSize + 1, itemCollection.getItems().size());
        assertTrue(itemCollection.getItems().contains(item1));
    }

    @Test
    public void testAddItemNull() {
        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            itemCollection.addItem(null);
        });
        assertEquals("Item cannot be null", exception.getMessage());
    }

    @Test
    public void testRemoveItem() {
        // Arrange
        itemCollection.addItem(item1);
        int initialSize = itemCollection.getItems().size();

        // Act
        itemCollection.removeItem(item1);

        // Assert
        assertEquals(initialSize - 1, itemCollection.getItems().size());
        assertFalse(itemCollection.getItems().contains(item1));
    }

    @Test
    public void testRemoveItemNotFound() {
        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            itemCollection.removeItem(item1);
        });
        assertEquals("Item not found in the collection", exception.getMessage());
    }

    @Test
    public void testGetItems() {
        // Arrange
        itemCollection.addItem(item1);
        itemCollection.addItem(item2);

        // Act
        List<Item> items = itemCollection.getItems();

        // Assert
        assertEquals(2, items.size());
        assertTrue(items.contains(item1));
        assertTrue(items.contains(item2));
    }
}


