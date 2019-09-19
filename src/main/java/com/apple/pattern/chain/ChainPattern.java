package com.apple.pattern.chain;

public class ChainPattern {

    public static AbstractLogger getChainLogger() {
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.DEBUG);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.INFO);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.DEBUG);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger chainLogger = getChainLogger();

        chainLogger.logMessage(AbstractLogger.INFO, "this is file logger");

        chainLogger.logMessage(AbstractLogger.ERROR, "this is error logger");

        chainLogger.logMessage(AbstractLogger.DEBUG, "this is console logger");

    }
}
