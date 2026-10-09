package ru.mirea.lab4_1.task9;

public class Chair extends Furniture {
    private boolean hasArmrests;

    public Chair(String name, String material, double price, boolean hasArmrests) {
        super(name, material, price);
        this.hasArmrests = hasArmrests;
    }

    public boolean hasArmrests() { return hasArmrests; }

    @Override public String getPurpose() { return hasArmrests ? "сидеть с комфортом" : "сидеть"; }
}
