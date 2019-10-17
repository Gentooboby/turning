package com.apple.thinking.concurrency;

import java.util.concurrent.ThreadFactory;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class DaemonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setDaemon(true);
        return thread;
    }
}
