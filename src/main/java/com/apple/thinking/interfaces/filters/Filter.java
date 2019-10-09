package com.apple.thinking.interfaces.filters;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class Filter {
    public String name() {
        return getClass().getSimpleName();
    }

    public Waveform process(Waveform input) {
        return input;
    }
}
