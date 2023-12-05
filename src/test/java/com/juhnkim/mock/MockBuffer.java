package com.juhnkim.mock;

import com.juhnkim.Buffer;
import com.juhnkim.Item;

import java.util.Queue;

public class MockBuffer extends Buffer {

    public Queue<Item> getBufferQueue() {
        return super.buffer;
    }


}
