package com.juhnkim;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProducerTest {

    private Producer producer;
    private MockBufferHelper mockBufferHelper;
    private MockItem mockItem;

    @BeforeEach
    public void setUp() {
        mockBufferHelper = new MockBufferHelper();
        mockItem = new MockItem("Test");
        producer = new MockProducerHelper(mockBufferHelper, mockItem); // Your actual Producer implementation
    }

    @Test
    public void testProducerProducesItem() {
        Queue<Item> bufferQueue = mockBufferHelper.getBufferQueue();
        assertTrue(bufferQueue.isEmpty(), "Buffer should be empty before producing");
        producer.run(); // Assuming you have a method to produce an item once
        assertTrue(bufferQueue.contains(mockItem), "Buffer should not be empty after producing");
        producer.stopRunning();
    }
}
