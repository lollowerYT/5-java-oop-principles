package com.example.task04;

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler {

    private final String baseName;
    private final ChronoUnit unit;

    private LocalDateTime currentPeriodStart;
    private String currentFileName;

    public RotationFileHandler(String baseName, ChronoUnit unit) {
        this.baseName = baseName;
        this.unit = unit;
        updateFileIfNeeded();
    }

    private void updateFileIfNeeded() {
        LocalDateTime now = LocalDateTime.now().truncatedTo(unit);

        // Если период сменился → создаём новый файл
        if (currentPeriodStart == null || !now.equals(currentPeriodStart)) {
            currentPeriodStart = now;

            String timestamp = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm"));
            currentFileName = baseName + "_" + timestamp + ".log";
        }
    }

    @Override
    public void handle(String message) {
        updateFileIfNeeded();

        try (FileWriter writer = new FileWriter(currentFileName, true)) {
            writer.write(message + System.lineSeparator());
        } catch (Exception e) {
            System.err.println("Ошибка записи в файл: " + e.getMessage());
        }
    }
}
