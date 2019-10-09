package com.apple.thinking.interfaces.interfaceprocessor;

import com.apple.thinking.interfaces.filters.BandPass;
import com.apple.thinking.interfaces.filters.HighPass;
import com.apple.thinking.interfaces.filters.LowPass;
import com.apple.thinking.interfaces.filters.Waveform;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class FilterProcessor {

    public static void main(String[] args) {
        Waveform w = new Waveform();
        Apply.process(new FilterAdapter(new LowPass(1.0)), w);
        Apply.process(new FilterAdapter(new HighPass(2.0)), w);
        Apply.process(new FilterAdapter(new BandPass(3.0, 4.0)), w);
    }
}
