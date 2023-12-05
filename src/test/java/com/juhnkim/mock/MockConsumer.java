package com.juhnkim.mock;

import com.juhnkim.Consumer;

public class MockConsumer implements Consumer {

    private final MockBuffer mockBuffer;

    public MockConsumer(MockBuffer mockBuffer) {
        this.mockBuffer = mockBuffer;
    }

    public void removeItem()  {
        mockBuffer.remove();
    }

    @Override
    public void run() {
    }

    @Override
    public void stopRunning() {
    }

}
