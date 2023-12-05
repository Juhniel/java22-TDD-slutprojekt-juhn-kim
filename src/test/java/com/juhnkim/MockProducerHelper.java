package com.juhnkim;

public class MockProducerHelper implements Producer{

    // Vi måste mocka buffert listan här
    private final MockBufferHelper mockBufferHelper;


    private boolean running = false;
    private final Item itemToProduce;

    public MockProducerHelper(MockBufferHelper mockBufferHelper, Item itemToProduce) {
        this.mockBufferHelper = mockBufferHelper;
        this.itemToProduce = itemToProduce;
    }
    @Override
    public void run()  {
        running = true;
        while(running) {
            mockBufferHelper.add(itemToProduce);
            // här behöver vi använda wait() för att inte överproducera
        }
    }

    @Override
    public void stopRunning() {
        running = false;
    }
}
