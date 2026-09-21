package ru.mirea.lab1;

public class task_3 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Аргументы не переданы.");
            return;
        }

        System.out.println("Аргументы командной строки:");
        for (int i = 0; i < args.length; i++) {
            System.out.println("Аргумент " + (i + 1) + ": " + args[i]);
        }

    }
}