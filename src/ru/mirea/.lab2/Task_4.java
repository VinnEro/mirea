package ru.mirea.lab2;
import java.util.Scanner;

public class Task_4 {
    public static void main(String[] args) {
        Shop shop = new Shop(10);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Сколько ПК добавить? ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Введите название ПК: ");
            shop.addComputer(new Computer(scanner.nextLine()));
        }

        System.out.print("Какой ПК найти? ");
        String search = scanner.nextLine();
        Computer found = shop.findComputer(search);
        System.out.println(found != null ? "Найден: " + found.getName() : "Не найден");
    }
}

interface ComputerManager {
    void addComputer(Computer c);
    void removeComputer(String name);
    Computer findComputer(String name);
}

class Computer {
    private String name;
    public Computer(String name) { this.name = name; }
    public String getName() { return name; }
}

class Shop implements ComputerManager {
    private Computer[] inventory;
    private int count = 0;

    public Shop(int capacity) { inventory = new Computer[capacity]; }

    public void addComputer(Computer c) {
        if (count < inventory.length) inventory[count++] = c;
    }

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

    public Computer findComputer(String name) {
        for (int i = 0; i < count; i++) {
            if (inventory[i].getName().equals(name)) return inventory[i];
        }
        return null;
    }
}