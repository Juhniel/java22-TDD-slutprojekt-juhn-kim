package com.juhnkim;

/**
 * Needs buffer to put Item in.
 * run starts Consumer
 * stopRunning stops Consumer
 */
public interface Consumer {
    public void run() throws InterruptedException;
    public void stopRunning();
}
