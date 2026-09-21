package ru.mirea.lab1;

public class task_4 {
    public static void main(String[] args) {
        System.out.println("Первые 10 чисел гармонического ряда:");
        for (int i = 1; i <= 10; i++) {
            System.out.printf("Число %d: %.3f%n", i, 1.0 / i);
        }
    }
}