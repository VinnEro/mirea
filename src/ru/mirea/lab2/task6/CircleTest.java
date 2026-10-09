// Файл CircleTest.java
package ru.mirea.lab2.task6;

public class CircleTest {
    public static void main(String[] args) {
        CircleModel c1 = new CircleModel(5.0);
        CircleModel c2 = new CircleModel(7.0);
        System.out.println("Площадь c1: " + c1.getArea());
        System.out.println("Длина c1: " + c1.getLength());
        System.out.println("Сравнение c1 и c2: " + c1.compareTo(c2));
    }
}