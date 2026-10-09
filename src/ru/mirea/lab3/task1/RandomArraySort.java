package ru.mirea.lab3.task1;
import java.util.Arrays;
import java.util.Random;

public class RandomArraySort {
    public static void main(String[] args) {
        int size = 10;

        // Способ 1: Math.random().
        // Math.random() всегда возвращает double из [0.0; 1.0), поэтому чтобы получить
        // число из нужного диапазона, результат приходится вручную растягивать и сдвигать:
        // [0; 1) * 100 -> [0; 100), а потом -50 -> [-50; 50). Удобно, когда нужно "одно случайное число и всё".
        double[] mathArray = new double[size];
        for (int i = 0; i < size; i++) {
            mathArray[i] = Math.random() * 100 - 50;
        }

        // Способ 2: класс Random.
        // Здесь мы создаём объект-генератор один раз и дальше просто просим у него числа.
        // Плюс Random в том, что у него много готовых методов (nextInt(bound), nextDouble(), nextBoolean()...),
        // а ещё в конструктор можно передать seed - тогда последовательность будет повторяемой (удобно для отладки).
        Random rand = new Random(); // obj-generator; .next[varType];
        double[] randomArray = new double[size];
        for (int i = 0; i < size; i++) {
            randomArray[i] = rand.nextDouble() * 100 - 50;
        }

        System.out.println("Массив (Math.random()):  " + format(mathArray));
        System.out.println("Массив (класс Random):   " + format(randomArray));

        // Arrays.sort для примитивного double[] использует быструю сортировку (Dual-Pivot Quicksort),
        // это O(n log n). Писать свой пузырёк тут смысла нет - задача про генерацию чисел, а не про сортировку.
        Arrays.sort(mathArray);
        Arrays.sort(randomArray);

        System.out.println();
        System.out.println("После сортировки (Math.random()): " + format(mathArray));
        System.out.println("После сортировки (класс Random):  " + format(randomArray));
    }

    // Arrays.toString() shows 15-16 sym after  после запятой - читать такое неудобно.
    // Поэтому собираем строку сами и округляем каждое число до двух знаков через String.format.
    private static String format(double[] array) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(String.format("%.2f", array[i]));
            if (i < array.length - 1) sb.append("; ");
        }
        return sb.append("]").toString();
    }
}
