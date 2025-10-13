package com.example.task01;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

class Logger {
    public enum LogLevel {DEBUG, INFO, WARNING, ERROR}

    private static final List<Logger> LOGGERS = new ArrayList<>();
    private final String name;
    private LogLevel level = LogLevel.DEBUG; // Уровень по умолчанию

    private Logger(String name) {
        this.name = name;
        LOGGERS.add(this);
    }

    public String getName() {
        return name;
    }

    public void setLevel(LogLevel level) {
        this.level = level;
    }

    public LogLevel getLevel() {
        return level;
    }

    public static Logger getLogger(String name) {
        for (Logger logger : LOGGERS) {
            if (logger.name.equals(name)) {
                return logger;
            }
        }
        Logger newLogger = new Logger(name);
        return newLogger;
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void info(String format, Object... elems) {
        log(LogLevel.INFO, format, elems);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }

    public void error(String format, Object... elems) {
        log(LogLevel.ERROR, format, elems);
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void debug(String format, Object... elems) {
        log(LogLevel.DEBUG, format, elems);
    }

    public void warning(String message) {
        log(LogLevel.WARNING, message);
    }

    public void warning(String format, Object... elems) {
        log(LogLevel.WARNING, format, elems);
    }

    public void log(LogLevel level, String message) {
        printMessage(level, message);
    }

    public void log(LogLevel level, String format, Object... elems) {
        String message = MessageFormat.format(format, elems);
        printMessage(level, message);
    }

    private void printMessage(LogLevel level, String message) {
        if (level.ordinal() >= this.level.ordinal()) {
            String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
            System.out.println(MessageFormat.format("[{0}] {1} {2} - {3}",
                    level, dateTime, name, message));
        }
    }
}




public class Task01Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getLogger("test");
        Logger logger2 = Logger.getLogger("test");

        System.out.println(logger1 == logger2); // true

        // Исправлено: LogLevel вместо Level
        logger1.setLevel(Logger.LogLevel.INFO);

        logger1.debug("This debug will not be printed");
        logger1.info("Application started");
        logger1.warning("Low memory: %d MB", 512);
        logger1.error("Unhandled exception: %s", "NullPointerException");
    }
}

