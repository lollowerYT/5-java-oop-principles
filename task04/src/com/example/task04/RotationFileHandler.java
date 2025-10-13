package com.example.task04;

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler {
    private String fileName;
    private ChronoUnit chronoUnit;

    public RotationFileHandler(String fileName, ChronoUnit chronoUnit) {
        this.fileName = fileName;
        this.chronoUnit = chronoUnit;
    }

    @Override
    public void log(String message) {
        LocalDateTime now = LocalDateTime.now();
        String timestamp = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
        String fullFileName = fileName + "_" + timestamp + ".log";

        try (FileWriter writer = new FileWriter(fullFileName, true)) {
            writer.write(message + "\n");
        } catch (Exception e) {
            System.err.println("Ошибка записи в файл: " + e.getMessage());
        }
    }
}
