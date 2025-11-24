package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements MessageHandler {

    private final String filename;

    public FileHandler(String filename) {
        this.filename = filename;
    }

    @Override
    public void handle(String message) {
        try (FileWriter fw = new FileWriter(filename, true)) {
            fw.write(message + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
