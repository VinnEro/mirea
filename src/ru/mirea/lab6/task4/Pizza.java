package ru.mirea.lab6.task4;

public class Pizza implements Priceable {
    private String name;
    private int diameterCm;

    public Pizza(String name, int diameterCm) { this.name = name; this.diameterCm = diameterCm; }

    // Цена не хранится, а вычисляется: зависит от площади пиццы. Интерфейсу это не важно -
    // он требует только, чтобы метод getPrice() вернул число.
    @Override public double getPrice() { return Math.PI * diameterCm * diameterCm / 4 * 1.2; }

    @Override public String toString() { return "Пицца \"" + name + "\" " + diameterCm + " см"; }
}
