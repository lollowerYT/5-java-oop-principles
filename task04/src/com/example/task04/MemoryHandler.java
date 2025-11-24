package com.example.task04;

import java.util.ArrayList;
import java.util.List;

public class MemoryHandler implements MessageHandler {

    private final List<String> buffer = new ArrayList<>();
    private final MessageHandler target;
    private final int maxSize;

    public MemoryHandler(MessageHandler target, int maxSize) {
        this.target = target;
        this.maxSize = maxSize;
    }

    @Override
    public void handle(String message) {
        buffer.add(message);
        if (buffer.size() >= maxSize) flush();
    }

    public void flush() {
        for (String m : buffer) target.handle(m);
        buffer.clear();
    }
}
