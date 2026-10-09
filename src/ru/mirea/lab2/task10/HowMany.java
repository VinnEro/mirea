package ru.mirea.lab2.task10;
import java.util.Scanner;

public class HowMany {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку:");
        String input = sc.nextLine().trim();

        if (input.isEmpty()) {
            System.out.println("Вы ввели 0 слов.");
        } else {
            System.out.println("Количество слов: " + input.split("\\s+").length);
        }
    }
}