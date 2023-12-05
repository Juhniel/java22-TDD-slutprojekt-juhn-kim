package com.juhnkim.mock;

import com.juhnkim.Buffer;
import com.juhnkim.Consumer;

public class MockConsumer implements Consumer {

    private final MockBuffer mockBuffer;


    public MockConsumer(MockBuffer mockBuffer) {
        this.mockBuffer = mockBuffer;
    }

    public boolean removeItem() {
        mockBuffer.remove();
        return true;
    }

    @Override
    public void run() {
    }

    @Override
    public void stopRunning() {
    }

}
