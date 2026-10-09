package ru.mirea.lab7.task5;
import java.util.Scanner;

public class ProcessStringsTest {
    public static void main(String[] args) {
        StringProcessable p = new ProcessStrings();

        Scanner sc = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String s = sc.nextLine();

        System.out.println("Количество символов: " + p.countChars(s));
        System.out.println("Количество пробелов: " + p.countChar(s, ' '));
        System.out.println("Символы на нечётных позициях (1, 3, 5...): " + p.oddPositions(s));
        System.out.println("Инвертированная строка: " + p.invert(s));

        // Граничные случаи, на которых чаще всего ломаются такие методы.
        System.out.println("\nПроверка на пустой строке: \"" + p.oddPositions("") + "\", \"" + p.invert("") + "\"");
        System.out.println("Проверка на одном символе: \"" + p.oddPositions("A") + "\", \"" + p.invert("A") + "\"");
    }
}
