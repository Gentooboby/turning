package com.apple.thinking.extend;

import static com.apple.util.Print.print;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class Hide {
    public static void main(String[] args) {
        Bart b = new Bart();
        b.doh(1);
        b.doh('c');
        b.doh(1.0f);
        b.doh(new Milhouse());
    }
}

class Homer {
    char doh(char c) {
        print("doh(char)");
        return 'd';
    }

    float doh(float f) {
        print("doh(float)");
        return 0.1f;
    }
}

class Milhouse {
}

class Bart extends Homer {
    void doh(Milhouse m) {
        print("doh(Milhouse)");
    }
}

class Lisa extends Homer{
//    @Override
    void doh(Milhouse m){
        print("doh(Milhouse)");
    }
}


