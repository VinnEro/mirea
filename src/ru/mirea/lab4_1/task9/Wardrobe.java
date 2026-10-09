package ru.mirea.lab4_1.task9;

public class Wardrobe extends Furniture {
    private int doors;

    public Wardrobe(String name, String material, double price, int doors) {
        super(name, material, price);
        this.doors = doors;
    }

    @Override public String getPurpose() { return "хранить одежду, дверей: " + doors; }

    // Шкаф тяжёлый и большой - фиксированная доплата за каждую дверь сверх базовой доставки.
    @Override public double getDeliveryCost() { return super.getDeliveryCost() + 500 * doors; }
}
