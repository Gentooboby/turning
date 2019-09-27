package com.apple.thinking.extend;

import static com.apple.util.Print.print;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class Orc extends Villain {
    private int orcNumber;

    public Orc(String name, int orcNumber) {
        super(name);
        this.orcNumber = orcNumber;
    }

    public void change(String name, int orcNumber) {
        set(name);
        this.orcNumber = orcNumber;
    }

    @Override
    public String toString() {
        return "Orc" + orcNumber + ": " + super.toString();
    }

    public static void main(String[] args) {
        Orc orc = new Orc("Limburger",12);
        print(orc);
        orc.change("Bob",19);
        print(orc);
    }
}

class Villain {
    private String name;

    protected void set(String nm) {
        this.name = nm;
    }

    public Villain(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "I'm a Villain and my name is : " + name;
    }
}
