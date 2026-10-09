package ru.mirea.lab3.task2;
import java.util.Random;

public class Tester {
    private Circle[] circles;
    private int count = 0;

    public Tester(int size) { circles = new Circle[size]; }

    public void addCircle(Circle circle) { if (count < circles.length) circles[count++] = circle; }
    public void printCircles() { for (int i = 0; i < count; i++) System.out.println(circles[i]); }

    // Если окружностей нет, честно возвращаем null, а не circles[0]:
    // в пустом массиве circles[0] тоже null, но так намерение явно видно в коде.
    public Circle getSmallest() {
        if (count == 0) return null;
        Circle smallest = circles[0];
        for (int i = 1; i < count; i++) {
            if (circles[i].compareTo(smallest) < 0) smallest = circles[i];
        }
        return smallest;
    }

    public Circle getLargest() {
        if (count == 0) return null;
        Circle largest = circles[0];
        for (int i = 1; i < count; i++) {
            if (circles[i].compareTo(largest) > 0) largest = circles[i];
        }
        return largest;
    }

    // Сортировка вставками по возрастанию радиуса.
    // Почему не пузырёк, как в Bookshelf из lab2? Вставками делает меньше обменов
    // и почти мгновенно работает на уже отсортированном массиве. Сортируем только первые count
    // элементов - хвост массива может быть заполнен null, и compareTo на нём упал бы с NPE.
    public void sortByRadius() {
        for (int i = 1; i < count; i++) {
            Circle current = circles[i];
            int j = i - 1;
            while (j >= 0 && circles[j].compareTo(current) > 0) {
                circles[j + 1] = circles[j];
                j--;
            }
            circles[j + 1] = current;
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        Tester tester = new Tester(5);

        // Центр и радиус генерируем случайно. Радиус берём из [1; 20), а не [0; 20):
        // окружность с нулевым радиусом - это уже не окружность, а точка.
        for (int i = 0; i < 5; i++) {
            Point center = new Point(rand.nextInt(21) - 10, rand.nextInt(21) - 10);
            double radius = 1 + rand.nextDouble() * 19;
            tester.addCircle(new Circle(center, radius));
        }

        System.out.println("Исходный массив окружностей:");
        tester.printCircles();

        System.out.println("\nСамая маленькая: " + tester.getSmallest());
        System.out.println("Самая большая:   " + tester.getLargest());

        tester.sortByRadius();
        System.out.println("\nПосле сортировки по радиусу:");
        tester.printCircles();
    }
}
