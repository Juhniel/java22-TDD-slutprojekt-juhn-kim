package com.juhnkim;

public class MockConsumerHelper implements Consumer {

    private final Buffer buffer;
    private boolean running = false;

    public MockConsumerHelper(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        running = true;
        while (running) {
            buffer.remove();
            // Här behöver vi också använda ngn logik eller wait för att inte överkonsumera
        }
    }

    @Override
    public void stopRunning() {
        running = false;
    }

}
