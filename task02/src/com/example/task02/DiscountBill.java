package com.example.task02;

public class DiscountBill extends Bill{
    private double discountPercentage = 10;

    public DiscountBill(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    // Метод получения процента скидки
    public double getDiscountPercentage() {
        return discountPercentage;
    }

    // Метод получения итоговой суммы со скидкой
    @Override
    public long getPrice() {
        return (long) (super.getPrice() * (1 - discountPercentage / 100));
    }

    // Метод получения абсолютного значения скидки
    public long getDiscountAmount() {
        return super.getPrice() - getPrice();
    }

    // Метод для строкового представления процента скидки
    public String getDiscount() {
        return String.format("%.2f", discountPercentage) + "%";
    }
}
