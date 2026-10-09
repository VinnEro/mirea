package ru.mirea.lab4.task2;

// Футболка унисекс: Java не даёт наследовать два класса, но реализовать сколько угодно интерфейсов - можно.
public class TShirt extends Clothes implements MenClothing, WomenClothing {
    public TShirt(Size size, double cost, String color) { super(size, cost, color); }

    @Override public String getName() { return "Футболка"; }
    @Override public void dressMan() { System.out.println("Мужчина надевает: " + this); }
    @Override public void dressWomen() { System.out.println("Женщина надевает: " + this); }
}
