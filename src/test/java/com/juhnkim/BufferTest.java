package com.juhnkim;

import com.juhnkim.mock.MockBuffer;
import com.juhnkim.mock.MockConsumer;
import com.juhnkim.mock.MockItem;
import com.juhnkim.mock.MockProducer;
import org.junit.jupiter.api.BeforeEach;
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
        mockBuffer = new MockBuffer();
        mockItem = new MockItem("test");
    }

    @Test
    public void testAddItem() {
        assertTrue(mockProducer.add(mockItem), "Buffer should not be empty after adding an item");
    }

    @Test
    public void testRemoveItem() {
        mockProducer.add(mockItem);
        assertTrue(mockConsumer.removeItem());
    }
}