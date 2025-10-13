package com.example.task03;

public class Task03Main {
    public static void main(String[] args) {
        TimeUnit unit1 = new Seconds(1000);
        printTimeUnit(unit1);
        testSeconds();
        testMinutes();
        testHours();
    }

    private static void printTimeUnit(TimeUnit unit) {
        System.out.println(String.format("Milliseconds: %d", unit.toMillis()));
        System.out.println(String.format("Seconds:      %d", unit.toSeconds()));
        System.out.println(String.format("Minutes:      %d", unit.toMinutes()));
    }

    private static void testSeconds() {
        System.out.println("Тестирование Seconds:");
        TimeUnit unit1 = new Seconds(3600);
        printTimeUnit(unit1);
        System.out.println("Hours: " + unit1.getHours());
        System.out.println();
    }

    private static void testMinutes() {
        System.out.println("Тестирование Minutes:");
        TimeUnit unit2 = new Minutes(60);
        printTimeUnit(unit2);
        System.out.println("Hours: " + unit2.getHours());
        System.out.println();
    }

    private static void testHours() {
        System.out.println("Тестирование Hours:");
        TimeUnit unit3 = new Hours(2);
        printTimeUnit(unit3);
        System.out.println("Hours: " + unit3.getHours());
        System.out.println();
    }
}
