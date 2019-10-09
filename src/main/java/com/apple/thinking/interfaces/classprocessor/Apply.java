package com.apple.thinking.interfaces.classprocessor;

import java.util.Arrays;

import static com.apple.util.Print.print;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class Apply {
    public static void process(Processor p, Object o) {
        print("Using Processor " + p.name());
        print(p.process(o));
    }

    public static String s = "Disagreement with beliefs is by definition incorrect";

    public static void main(String[] args) {
        process(new Upcase(), s);
        process(new Downcase(), s);
        process(new Splitter(), s);
    }
}

class Processor {
    public String name() {
        return getClass().getSimpleName();
    }

    Object process(Object input) {
        return input;
    }
}

class Upcase extends Processor {

    @Override
    String process(Object input) {
        return ((String) input).toUpperCase();
    }
}

class Downcase extends Processor {
    @Override
    String process(Object input) {
        return ((String) input).toUpperCase();
    }
}

class Splitter extends Processor {
    @Override
    String process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
}
