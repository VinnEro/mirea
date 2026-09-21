package ru.mirea.lab1;

import java.util.Scanner;

public class task_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IO.print("Введите размер массива: ");
        int size = sc.nextInt();

        if (size <= 0) {
            IO.println("Размер должен быть больше нуля.");
            return;
        }

        int[] array = new int[size];
        IO.println("Введите элементы массива:");
        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }

        int sumWhile = 0;
        int i = 0;
        int max = array[0];
        int min = array[0];

        while (i < array.length) {
            sumWhile += array[i];
            if (array[i] > max) max = array[i];
            if (array[i] < min) min = array[i];
            i++;
        }

        int sumDoWhile = 0;
        int j = 0;

        do {
            sumDoWhile += array[j];
            j++;
        } while (j < array.length);

        IO.println("Сумма элементов (цикл while): " + sumWhile);
        IO.println("Сумма элементов (цикл do-while): " + sumDoWhile);
        IO.println("Максимальный элемент: " + max);
        IO.println("Минимальный элемент: " + min);
    }
}