package ru.mirea.lab4.task2;

public class Skirt extends Clothes implements WomenClothing {
    public Skirt(Size size, double cost, String color) { super(size, cost, color); }

    @Override public String getName() { return "Юбка"; }
    @Override public void dressWomen() { System.out.println("Женщина надевает: " + this); }
}
