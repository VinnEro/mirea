package ru.mirea.lab6.task4;

public interface Priceable {
    double getPrice();

    // default-метод (Java 8+): реализация прямо в интерфейсе.
    // Цена со скидкой считается одинаково для всего, у чего есть цена, поэтому писать её в каждом классе незачем.
    // Классы получают метод "бесплатно", но могут переопределить его при необходимости.
    default double getPriceWithDiscount(double percent) {
        return getPrice() * (100 - percent) / 100;
    }
}
