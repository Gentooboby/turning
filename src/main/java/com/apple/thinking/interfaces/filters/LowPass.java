package com.apple.thinking.interfaces.filters;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class LowPass extends Filter {
    double cutoff;

    public LowPass(double cutoff) {
        this.cutoff = cutoff;
    }

    @Override
    public Waveform process(Waveform input) {
        return input;
    }
}
