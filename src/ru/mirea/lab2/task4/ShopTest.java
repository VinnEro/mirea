package ru.mirea.lab2.task4;
import java.util.Scanner;

public class ShopTest {
    public static void main(String[] args) {
        Shop shop = new Shop(10);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Сколько ПК добавить? ");
        int n = scanner.nextInt(); scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Введите название ПК: ");
            shop.addComputer(new Computer(scanner.nextLine()));
        }

        System.out.print("Какой ПК найти? ");
        Computer found = shop.findComputer(scanner.nextLine());
        System.out.println(found != null ? "Найден: " + found.getName() : "Не найден");
    }
}