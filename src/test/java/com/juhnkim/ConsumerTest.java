package com.juhnkim;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConsumerTest {

    private Consumer consumer;
    private MockProducerHelper mockProducer;
    private MockBufferHelper mockBufferHelper;

    @BeforeEach
    public void setUp() {
        mockBufferHelper = new MockBufferHelper();
        consumer = new MockConsumerHelper(mockBufferHelper); // Your actual Consumer implementation
        mockProducer = new MockProducerHelper(mockBufferHelper, new Item("test"));
    }

    @Test
    public void testConsumerConsumesItem() throws InterruptedException {
        Queue<Item> bufferQueue = mockBufferHelper.getBufferQueue();
        // Initially, the buffer should be empty
        assertTrue(bufferQueue.isEmpty(), "Buffer should be initially empty");

        // Start mock producer to add items to the buffer
        mockProducer.run();
        bufferQueue = mockBufferHelper.getBufferQueue();

        // Start consumer to consume items
        consumer.run();

        assertTrue(bufferQueue.isEmpty(), "Buffer should be empty after consumed");

    }

    // Additional tests as needed
}
