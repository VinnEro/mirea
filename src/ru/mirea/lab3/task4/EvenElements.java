package ru.mirea.lab3.task4;
import java.util.Arrays;
import java.util.Scanner;

public class EvenElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;

        // Спрашиваем, пока пользователь не введёт натуральное число.
        // hasNextInt() проверяет ввод ДО чтения: если там "abc", nextInt() бросил бы InputMismatchException.
        // В этом случае "съедаем" неправильный токен через next(), иначе он так и останется в потоке
        // и цикл станет бесконечным.
        while (n <= 0) {
            System.out.print("Введите размер массива (натуральное число): ");
            if (sc.hasNextInt()) {
                n = sc.nextInt();
                if (n <= 0) System.out.println("Число должно быть больше нуля, попробуйте ещё раз.");
            } else {
                System.out.println("Это не целое число, попробуйте ещё раз.");
                sc.next();
            }
        }

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            // Отрезок [0; n] включает n + 1 значение, поэтому умножаем на (n + 1).
            array[i] = (int) (Math.random() * (n + 1));
        }
        System.out.println("Исходный массив: " + Arrays.toString(array));

        // Массивы в Java фиксированного размера, поэтому сначала считаем, сколько чётных,
        // и только потом создаём второй массив ровно нужной длины. Так не остаётся "пустых" нулей в хвосте,
        // которые было бы невозможно отличить от настоящих чётных нулей.
        int evenCount = 0;
        for (int value : array) {
            if (value % 2 == 0) evenCount++;
        }

        if (evenCount == 0) {
            System.out.println("Чётных элементов нет.");
            return;
        }

        int[] even = new int[evenCount];
        int index = 0;
        for (int value : array) {
            if (value % 2 == 0) even[index++] = value;
        }
        System.out.println("Чётные элементы: " + Arrays.toString(even));
    }
}
