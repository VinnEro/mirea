package ru.mirea.lab2;
import java.util.Arrays;

public class Task_8 {
    public static void main(String[] args) {
        String[] arr = {"One", "Two", "Three", "Four", "Five"};
        System.out.println("Исходный массив: " + Arrays.toString(arr));

        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            String temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }

        System.out.println("Измененный массив: " + Arrays.toString(arr));
    }
}