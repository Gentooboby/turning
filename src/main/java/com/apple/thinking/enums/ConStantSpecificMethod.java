package com.apple.thinking.enums;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public enum ConStantSpecificMethod {
    DATE_TIME {
        @Override
        String getInfo() {
            return DateFormat.getDateInstance().format(new Date());
        }
    },
    CLASSPATH {
        @Override
        String getInfo() {
            return System.getenv("CLASSPATH");
        }
    },
    VERSION {
        @Override
        String getInfo() {
            return System.getProperty("java.version");
        }
    };

    abstract String getInfo();

    public static void main(String[] args) {
        for (ConStantSpecificMethod csm : values()) {
            System.out.println(csm.getInfo());
        }
    }
}
