package ru.mirea.lab4.task2;

public class Tie extends Clothes implements MenClothing {
    public Tie(Size size, double cost, String color) { super(size, cost, color); }

    @Override public String getName() { return "Галстук"; }
    @Override public void dressMan() { System.out.println("Мужчина надевает: " + this); }
}
