package com.juhnkim;

import java.util.Queue;

public class MockBufferHelper extends Buffer{

    public Queue<Item> getBufferQueue() {
        return super.buffer;
    }
}
