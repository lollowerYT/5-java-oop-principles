package com.example.task04;

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

    // ✔ Новое: список обработчиков
    private final List<MessageHandler> handlers = new ArrayList<>();

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

    // ✔ Новое: добавление обработчиков
    public void addHandler(MessageHandler handler) {
        handlers.add(handler);
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
            String formatted = MessageFormat.format("[{0}] {1} {2} - {3}",
                    level, dateTime, name, message);

            // ✔ старое поведение
            System.out.println(formatted);

            // ✔ новое поведение — передать обработчикам
            for (MessageHandler handler : handlers) {
                handler.handle(formatted);
            }
        }
    }
}
