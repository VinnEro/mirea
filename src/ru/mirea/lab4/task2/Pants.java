package ru.mirea.lab4.task2;

public class Pants extends Clothes implements MenClothing, WomenClothing {
    public Pants(Size size, double cost, String color) { super(size, cost, color); }

    @Override public String getName() { return "Штаны"; }
    @Override public void dressMan() { System.out.println("Мужчина надевает: " + this); }
    @Override public void dressWomen() { System.out.println("Женщина надевает: " + this); }
}
