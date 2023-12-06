package com.juhnkim;

import com.juhnkim.mock.MockItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ItemTest {
    private MockItem mockItem;

    @BeforeEach
    public void setUp() {
        mockItem = new MockItem("Test");
    }

    @Test
    @DisplayName("Test if the id is set to the correct value and should equal to lowercase")
    public void testIdIsSetCorrectly() {
        assertEquals("test", mockItem.getId(), "Item ID should be set correctly and in lowercase");
    }

    @Test
    @DisplayName("Test if the id is set to the correct value and should equal to lowercase returned by toString method")
    public void testToStringReturnsCorrectId() {
        assertEquals("test", mockItem.toString(), "toString should return the correct ID");
    }

    @Test
    @DisplayName("Test if the id is set to the correct new value with setId and should equal to lowercase")
    public void testSetId() {
        mockItem.setId("NewID");
        assertEquals("newid", mockItem.getId(), "setId should correctly update the ID");
    }

    @Test
    @DisplayName("Constructor should convert an uppercase ID to lowercase")
    public void testConstructorWithUpperCaseInput() {
        mockItem = new MockItem("UPPERCASE");
        assertEquals("uppercase", mockItem.getId(), "ID should be converted to lowercase");
    }

    @Test
    @DisplayName("Constructor should convert a mixed case ID to lowercase")
    public void testConstructorWithMixedCaseInput() {
        mockItem = new MockItem("MiXeDCaSe");
        assertEquals("mixedcase", mockItem.getId(), "ID should be converted to lowercase");
    }

    @Test
    @DisplayName("Set ID should convert an uppercase ID to lowercase")
    public void testSetIdWithUpperCaseInput() {
        mockItem.setId("UPPERCASE");
        assertEquals("uppercase", mockItem.getId(), "ID should be converted to lowercase");
    }
    @Test
    @DisplayName("Set ID should convert a mixed case ID to lowercase")
    public void testSetIdWithMixedCaseInput() {
        mockItem.setId("MiXeDCaSe");
        assertEquals("mixedcase", mockItem.getId(), "ID should be converted to lowercase");
    }

    @Test
    @DisplayName("Constructor should correctly handle an empty string as ID")
    public void testConstructorWithEmptyString() {
        mockItem = new MockItem("");
        assertEquals("", mockItem.getId(), "ID should handle empty string correctly");
    }

    @Test
    @DisplayName("Set ID should correctly handle an empty string")
    public void testSetIdWithEmptyString() {
        mockItem.setId("");
        assertEquals("", mockItem.getId(), "ID should handle empty string correctly");
    }

    @Test
    @DisplayName("Constructor should throw NullPointerException for null input")
    public void testConstructorWithNullInput() {
        assertThrows(NullPointerException.class, () -> new MockItem(null));
    }

    @Test
    @DisplayName("Set ID should throw NullPointerException for null input")
    public void testSetIdWithNullInput() {
       assertThrows(NullPointerException.class, () -> mockItem.setId(null));
    }
}
