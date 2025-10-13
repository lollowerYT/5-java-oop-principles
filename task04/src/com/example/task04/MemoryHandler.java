package com.example.task04;

import java.util.ArrayList;
import java.util.List;

public class MemoryHandler implements MessageHandler {
    private int bufferSize;
    private List<String> buffer = new ArrayList<>();
    private MessageHandler targetHandler;

    public MemoryHandler(MessageHandler targetHandler, int bufferSize) {
        this.targetHandler = targetHandler;
        this.bufferSize = bufferSize;
    }

    @Override
    public void log(String message) {
        buffer.add(message);
        if (buffer.size() >= bufferSize) {
            flush();
        }
    }

    public void flush() {
        for (String msg : buffer) {
            targetHandler.log(msg);
        }
        buffer.clear();
    }
}
