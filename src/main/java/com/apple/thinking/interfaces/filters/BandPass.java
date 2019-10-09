package com.apple.thinking.interfaces.filters;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class BandPass extends Filter {
    double lowCutoff, highCutoff;

    public BandPass(double lowCutoff, double highCutoff) {
        this.lowCutoff = lowCutoff;
        this.highCutoff = highCutoff;
    }

    @Override
    public Waveform process(Waveform input) {
        return input;
    }
}
