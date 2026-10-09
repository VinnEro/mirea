package ru.mirea.lab4_1.task9;

public class Sofa extends Furniture {
    private boolean foldable;

    public Sofa(String name, String material, double price, boolean foldable) {
        super(name, material, price);
        this.foldable = foldable;
    }

    @Override public String getPurpose() { return foldable ? "сидеть и спать (раскладной)" : "сидеть"; }
    @Override public double getDeliveryCost() { return 2000; }
}
