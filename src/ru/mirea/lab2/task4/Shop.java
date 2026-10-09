package ru.mirea.lab2.task4;

public class Shop implements ComputerManager {
    private Computer[] inventory;
    private int count = 0;

    public Shop(int capacity) { inventory = new Computer[capacity]; }

    @Override
    public void addComputer(Computer c) { if (count < inventory.length) inventory[count++] = c; }

    @Override
    public void removeComputer(String name) {
        for (int i = 0; i < count; i++) {
            if (inventory[i].getName().equals(name)) {
                inventory[i] = inventory[count - 1];
                inventory[count - 1] = null;
                count--;
                break;
            }
        }
    }

    @Override
    public Computer findComputer(String name) {
        for (int i = 0; i < count; i++) {
            if (inventory[i].getName().equals(name)) return inventory[i];
        }
        return null;
    }
}