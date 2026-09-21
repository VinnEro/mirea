package ru.mirea.lab1;

public class Task7 {
    public static void main(String[] args) {
        int num = 5;
        int result = fact(num);
        System.out.println("Факториал числа " + num + " равен: " + result);
    }

    public static int fact(int n) {
        if (n < 0) return 0;
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}