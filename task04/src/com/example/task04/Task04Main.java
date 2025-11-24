package com.example.task04;

import java.time.temporal.ChronoUnit;

public class Task04Main {
    public static void main(String[] args) {

        // Получаем логгер
        Logger logger = Logger.getLogger("TestLogger");

        // Устанавливаем минимальный уровень логирования
        logger.setLevel(Logger.LogLevel.DEBUG);

        // Добавляем обычный вывод в консоль
        logger.addHandler(new ConsoleHandler());

        // Добавляем запись в один файл
        logger.addHandler(new FileHandler("app.log"));

        // Добавляем файл с ротацией (новый файл каждый час)
        logger.addHandler(new RotationFileHandler("rotate", ChronoUnit.HOURS));

        // Памятный обработчик — собирает сообщения по 3 шт и затем выводит в ConsoleHandler
        MemoryHandler memoryHandler = new MemoryHandler(new ConsoleHandler(), 3);
        logger.addHandler(memoryHandler);

        // Логируем несколько сообщений
        logger.debug("Debug message");
        logger.info("Info message");
        logger.warning("Warning message: {0}", 42);
        logger.error("Error occurred: {0}", "Something went wrong!");

        // MemoryHandler сбрасывает сообщения вручную
        System.out.println("---- Manual flush ----");
        memoryHandler.flush();

        System.out.println("Done!");
    }
}
