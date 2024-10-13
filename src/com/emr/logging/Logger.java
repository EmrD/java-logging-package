package com.emr.logging;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    private LogLevel currentLevel;
    private PrintWriter writer;

    public Logger(LogLevel level) {
        this.currentLevel = level;
        try {
            this.writer = new PrintWriter(new FileWriter("application.log", true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void log(LogLevel level, String message) {
        if (level.ordinal() >= currentLevel.ordinal()) {
            LogMessage logMessage = new LogMessage(level, message);
            writer.println(logMessage.toString());
            writer.flush(); 
        }
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void warn(String message) {
        log(LogLevel.WARN, message);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }

    public void close() {
        writer.close();
    }
}
