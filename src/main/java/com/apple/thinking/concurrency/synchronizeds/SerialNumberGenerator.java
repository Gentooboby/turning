package com.apple.thinking.concurrency.synchronizeds;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;

    public static int nextSerialNumber() {
        return serialNumber++;
    }
}
