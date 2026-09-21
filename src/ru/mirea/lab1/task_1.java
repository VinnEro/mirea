package ru.mirea.lab1;
import java.util.Arrays;


public class task_1 {
    public static void main(String[] args) {
        int[] numbers = {15, 23, 8, 42, 4}; // Инициализация
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        double average = (double) sum / numbers.length;
        IO.println("Массив: " + Arrays.toString(numbers));
        System.out.println("Сумма элементов: " + sum);
        System.out.println("Среднее арифметическое: " + average);
    }
}