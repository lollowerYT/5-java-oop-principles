package com.example.task04;

public class ConsoleHandler implements MessageHandler {
    @Override
    public void handle(String Message) {
        System.out.println(Message);
    }

    @Override
    public void close() { }
}
