package ru.mirea.lab2;
import java.util.Scanner;

public class Task_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку:");
        String input = sc.nextLine().trim();

        if (input.isEmpty()) {
            System.out.println("Вы ввели 0 слов.");
        } else {
            String[] words = input.split("\\s+");
            System.out.println("Количество слов: " + words.length);
        }
    }
}