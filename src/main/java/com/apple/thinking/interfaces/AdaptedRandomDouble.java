package com.apple.thinking.interfaces;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Scanner;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class AdaptedRandomDouble implements RandomDoubles, Readable {
    private int count;

    public AdaptedRandomDouble(int count) {
        this.count = count;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (count-- == 0) {
            return -1;
        }

        String result = Double.toString(next()) + " ";
        cb.append(result);
        return result.length();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(new AdaptedRandomDouble(7));
        while (s.hasNext()) {
            System.out.println(s.next());
        }
    }
}
