package ru.mirea.lab6.task4;

public class PriceableTest {
    public static void main(String[] args) {
        Priceable[] cart = {
                new Pizza("Маргарита", 30),
                new Ticket("Концерт", 3000, false),
                new Ticket("Концерт", 3000, true),
                new Smartphone("Pixel 8", 54990)
        };

        double total = 0, totalDiscount = 0;
        System.out.printf("%-28s %12s %14s%n", "Товар", "Цена", "Со скидкой 10%");
        for (Priceable item : cart) {
            System.out.printf("%-28s %,12.2f %,14.2f%n", item, item.getPrice(), item.getPriceWithDiscount(10));
            total += item.getPrice();
            totalDiscount += item.getPriceWithDiscount(10);
        }
        System.out.printf("%-28s %,12.2f %,14.2f%n", "ИТОГО", total, totalDiscount);
    }
}
