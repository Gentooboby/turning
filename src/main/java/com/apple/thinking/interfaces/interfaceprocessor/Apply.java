package com.apple.thinking.interfaces.interfaceprocessor;

import static com.apple.util.Print.print;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class Apply {
    public static void process(Processor p, Object s){
        print("Using processor " + p.name());
        print(p.process(s));
    }
}
