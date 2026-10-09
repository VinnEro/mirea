package ru.mirea.lab6.task4;

public class Smartphone implements Priceable {
    private String model;
    private double price;

    public Smartphone(String model, double price) { this.model = model; this.price = price; }

    @Override public double getPrice() { return price; }
    @Override public String toString() { return "Смартфон " + model; }
}
