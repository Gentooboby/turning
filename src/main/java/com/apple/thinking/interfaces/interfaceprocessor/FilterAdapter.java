package com.apple.thinking.interfaces.interfaceprocessor;

import com.apple.thinking.interfaces.filters.Filter;
import com.apple.thinking.interfaces.filters.Waveform;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class FilterAdapter implements Processor {
    Filter filter;

    public FilterAdapter(Filter filter) {
        this.filter = filter;
    }

    @Override
    public String name() {
        return filter.name();
    }

    @Override
    public Object process(Object input) {
        return filter.process((Waveform) input);
    }
}
