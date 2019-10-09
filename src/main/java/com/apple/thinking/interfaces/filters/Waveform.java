package com.apple.thinking.interfaces.filters;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class Waveform {
    private static long counter;
    private final long id = counter ++;

    @Override
    public String toString() {
        return "Waveform " + id;
    }
}

