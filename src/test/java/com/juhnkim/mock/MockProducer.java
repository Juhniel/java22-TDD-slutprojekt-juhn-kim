package com.juhnkim.mock;

import com.juhnkim.Producer;

public class MockProducer implements Producer {

    private final MockBuffer mockBuffer;

    public MockProducer(MockBuffer mockBuffer) {
        this.mockBuffer = mockBuffer;
    }

    public boolean add(MockItem mockItem) {
        mockBuffer.add(mockItem);
        return true;
    }

    @Override
    public void run() {
    }

    @Override
    public void stopRunning() {
    }

}
