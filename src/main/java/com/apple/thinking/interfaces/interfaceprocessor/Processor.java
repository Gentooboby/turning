package com.apple.thinking.interfaces.interfaceprocessor;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public interface Processor {
    String name();

    Object process(Object input);
}
