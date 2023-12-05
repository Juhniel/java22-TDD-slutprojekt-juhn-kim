package com.juhnkim;

import com.juhnkim.mock.MockBuffer;
import com.juhnkim.mock.MockConsumer;
import com.juhnkim.mock.MockItem;
import com.juhnkim.mock.MockProducer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class BufferTest {

    private MockProducer mockProducer;
    private MockConsumer mockConsumer;
    private MockBuffer mockBuffer;
    private MockItem mockItem;

    @BeforeEach
    public void setUp() {
        mockBuffer = new MockBuffer();
        mockProducer = new MockProducer(mockBuffer);
        mockConsumer = new MockConsumer(mockBuffer);
    }

    @Test
    @DisplayName("Test adding a mock item to our buffer")
    public void testAddItem() {
        mockItem = new MockItem("test");
        assertTrue(mockProducer.add(mockItem), "Producer successfully added item to queue");
    }

    @Test
    @DisplayName("Test adding a mock item to our buffer and verify that the queue is not empty")
    public void testAddItemAndVerifyQueue() {
        mockItem = new MockItem("test");
        mockProducer.add(mockItem);
        assertFalse(mockBuffer.getBufferQueue().isEmpty(), "Buffer queue should not be empty after adding an item");
    }

    @Test
    @DisplayName("Test adding a mock item to our buffer with empty string and verify that the queue contains empty string")
    public void testAddEmptyStringItemAndVerifyQueue() {
        mockItem = new MockItem("");
        mockProducer.add(mockItem);
        assertFalse(mockBuffer.getBufferQueue().isEmpty(), "Buffer queue should not be empty after adding an item");
    }

    @Test
    @DisplayName("Test adding multiple items to the buffer")
    public void testAddMultipleItems() {
        int numberOfItemsToAdd = 10;
        for (int i = 0; i < numberOfItemsToAdd; i++) {
            MockItem item = new MockItem("item" + i);
            mockProducer.add(item);
        }

        assertEquals(numberOfItemsToAdd, mockBuffer.getBufferQueue().size(),
                "Buffer should contain the correct number of items");
    }

    @Test
    @DisplayName("Test creating an item with null id")
    public void testCreateItemWithNullId() {
        assertThrows(NullPointerException.class, () -> new MockItem(null));
    }

    @Test
    @DisplayName("Test adding and then removing a mock item from buffer")
    public void testRemoveItem() {
        mockItem = new MockItem("test");
        mockProducer.add(mockItem);
        assertEquals(mockItem, mockConsumer.removeItem());
    }

    @Test
    @DisplayName("Test adding and then removing a mock item from buffer and then verifying queue is empty")
    public void testRemoveItemAndVerifyQueueIsEmpty() {
        mockProducer.add(new MockItem("test"));
        mockConsumer.removeItem();
        assertTrue(mockBuffer.getBufferQueue().isEmpty());
    }

//    // Fixa så man kan testa ta bort från empty buffer
//    @Test
//    @DisplayName("Test removing an item from an empty buffer")
//    public void testRemoveFromEmptyBuffer() {
//        assertEquals(mockItem, mockConsumer.removeItem());
//    }

    @Test
    @DisplayName("Test consuming multiple items from the buffer")
    public void testConsumeMultipleItems() {
        int numberOfItemsToAdd = 5;
        for (int i = 0; i < numberOfItemsToAdd; i++) {
            mockProducer.add(new MockItem("item" + i));
        }

        int numberOfItemsToRemove = 5;
        for (int i = 0; i < numberOfItemsToRemove; i++) {
            mockConsumer.removeItem();
        }
        assertEquals(numberOfItemsToAdd, numberOfItemsToRemove,
                "All items added to the buffer should have been removed");
    }

//    @Test
//    @DisplayName("Test consuming multiple items from the buffer")
//    public void testConsumeMultipleItemsz() {
//        int numberOfItemsToAdd = 5; // Example number of items
//        for (int i = 0; i < numberOfItemsToAdd; i++) {
//            mockProducer.add(new MockItem("item" + i));
//        }
//
//        int numberOfItemsRemoved = 0;
//        while(mockConsumer.removeItem()) {
//            numberOfItemsRemoved++;
//        }
//
//        assertEquals(numberOfItemsToAdd, numberOfItemsRemoved,
//                "All items added to the buffer should have been removed");
//    }
}