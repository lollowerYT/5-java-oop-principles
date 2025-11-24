package com.example.task02;

public class Task02Main {
    private static final Item ITEM1 = new Item("Товар 1", 10);
    private static final Item ITEM2 = new Item("Товар 2", 20);
    private static final Item ITEM3 = new Item("Товар 3", 30);
    private static final Item ITEM4 = new Item("Товар 4", 40);
    private static final Item ITEM5 = new Item("Товар 5", 50);
    private static final Item ITEM6 = new Item("Товар 6", 60);

    public static void main(String[] args) {
        // Тестирование обычного счета
        System.out.println("Тестирование обычного счета:");
        Bill bill = new Bill();
        bill.add(ITEM1, 10);
        bill.add(ITEM3, 3);
        bill.add(ITEM6, 1);
        System.out.println(bill);
        bill.add(ITEM3, 3);
        System.out.println(bill);

        System.out.println("\n----------------------------------------\n");

        // Тестирование счета со скидкой
        System.out.println("Тестирование счета со скидкой (15%):");
        Bill discountBill = new DiscountBill(15);

        // Добавляем товары
        discountBill.add(ITEM2, 2);
        discountBill.add(ITEM4, 1);
        discountBill.add(ITEM5, 3);

        // Выводим полную информацию
        System.out.println("Исходная сумма: " + discountBill.getPrice());
        System.out.println("Процент скидки: " + ((DiscountBill) discountBill).getDiscount());
        System.out.println("Сумма скидки: " + ((DiscountBill) discountBill).getDiscountAmount());
        System.out.println("Итоговая сумма со скидкой: " + ((DiscountBill) discountBill).getTotalAmount());

        // Выводим полный счет
        System.out.println("\nПолный счет:");
        System.out.println(discountBill);

        // Добавляем еще товары и проверяем изменения
        System.out.println("\nПосле добавления новых товаров:");
        discountBill.add(ITEM1, 5);
        discountBill.add(ITEM6, 2);

        // Выводим обновленную информацию
        System.out.println("Исходная сумма: " + discountBill.getPrice());
        System.out.println("Процент скидки: " + ((DiscountBill) discountBill).getDiscount());
        System.out.println("Сумма скидки: " + ((DiscountBill) discountBill).getDiscountAmount());
        System.out.println("Итоговая сумма со скидкой: " + ((DiscountBill) discountBill).getTotalAmount());

        // Выводим обновленный счет
        System.out.println("\nОбновленный счет:");
        System.out.println(discountBill);
    }
}
