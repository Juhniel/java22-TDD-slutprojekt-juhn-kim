package com.juhnkim;

import com.juhnkim.mock.MockItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemTest {
    private MockItem mockItem;

    @BeforeEach
    public void setUp() {
        mockItem = new MockItem("TEST");
    }

    @Test
    public void testIdIsSetCorrectly() {
        assertEquals("test", mockItem.getId(), "Item ID should be set correctly and in lower case");
    }

    @Test
    public void testToStringReturnsCorrectId() {
        assertEquals("test", mockItem.toString(), "toString should return the correct ID");
    }

    @Test
    public void testSetId() {
        mockItem.setId("NewID");
        assertEquals("newid", mockItem.getId(), "setId should correctly update the ID");
    }
}
