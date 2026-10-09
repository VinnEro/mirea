package ru.mirea.lab3.task3;
import java.util.Arrays;

public class IncreasingSequence {
    public static void main(String[] args) {
        int[] numbers = new int[4];

        // Нужен отрезок [10; 99] - это 90 возможных значений (99 - 10 + 1).
        // Math.random() * 90 даёт [0; 90), после (int) - целые 0..89, и +10 сдвигает в 10..99.
        // Частая ошибка - написать *89 и потерять число 99, поэтому считаем количество явно.
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 90) + 10;
        }

        System.out.println("Массив: " + Arrays.toString(numbers));

        // Строго возрастающая = каждый следующий БОЛЬШЕ предыдущего (равные соседи уже не подходят).
        // Достаточно найти хотя бы одну "неправильную" пару, дальше проверять бессмысленно - отсюда break.
        boolean increasing = true;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] <= numbers[i - 1]) {
                increasing = false;
                break;
            }
        }

        System.out.println(increasing
                ? "Массив является строго возрастающей последовательностью."
                : "Массив НЕ является строго возрастающей последовательностью.");
    }
}
