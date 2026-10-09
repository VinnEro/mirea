package ru.mirea.lab3.format.task2;

public class Product {
    private String name;
    private double priceRub;    // цену храним в одной валюте, а пересчитываем только при выводе

    public Product(String name, double priceRub) { this.name = name; this.priceRub = priceRub; }
    public String getName() { return name; }
    public double getPriceRub() { return priceRub; }
}
