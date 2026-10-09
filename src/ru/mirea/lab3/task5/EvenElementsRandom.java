package ru.mirea.lab3.task5;
import java.util.Random;
import java.util.Scanner;

// В методичке задание 5 дословно повторяет задание 4.
// Чтобы решение не было копией, здесь та же задача решена другими средствами:
// класс Random вместо Math.random(), do-while вместо while и проход по массиву в один цикл
// с выводом "на лету" вместо Arrays.toString.
public class EvenElementsRandom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        // do-while здесь естественнее, чем while: спросить нужно хотя бы один раз в любом случае,
        // и не приходится заранее инициализировать n "неправильным" значением, как в задании 4.
        do {
            System.out.print("Введите размер массива (натуральное число): ");
            while (!sc.hasNextInt()) {
                System.out.print("Нужно целое число, повторите ввод: ");
                sc.next();
            }
            n = sc.nextInt();
        } while (n <= 0);

        Random rand = new Random();
        int[] array = new int[n];
        int evenCount = 0;

        // Генерация и подсчёт чётных в одном проходе - второй раз пробегать массив только ради подсчёта незачем.
        // nextInt(n + 1) возвращает число из [0; n], то есть ровно наш отрезок.
        System.out.print("Исходный массив: ");
        for (int i = 0; i < n; i++) {
            array[i] = rand.nextInt(n + 1);
            if (array[i] % 2 == 0) evenCount++;
            System.out.print(array[i] + " ");
        }
        System.out.println();

        int[] even = new int[evenCount];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (array[i] % 2 == 0) even[index++] = array[i];
        }

        if (even.length == 0) {
            System.out.println("Чётных элементов нет.");
        } else {
            System.out.print("Чётные элементы: ");
            for (int value : even) System.out.print(value + " ");
            System.out.println();
        }
    }
}
