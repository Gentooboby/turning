package com.apple.pattern.chain;

public abstract class AbstractLogger {
    protected static final int INFO = 1;
    protected static final int DEBUG = 2;
    protected static final int ERROR = 3;

    protected int level;

    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message) {
        if (this.level <= level) {
            write(message);
        }

        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }

    }

    abstract protected void write(String message);
}
