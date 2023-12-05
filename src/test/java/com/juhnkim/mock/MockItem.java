package com.juhnkim.mock;

import com.juhnkim.Item;

public class MockItem extends Item {
    public MockItem(String id) {
        super(id);
    }

    public String getId() {
        return id;
    }
}