package ru.mirea.lab7.task4;

public interface MathCalculable {
    // Поле в интерфейсе автоматически public static final - это константа, общая для всех реализаций.
    // Явно писать модификаторы не нужно, компилятор добавит их сам.
    double PI = 3.141592653589793;

    double pow(double base, int exponent);

    // Модуль комплексного числа z = re + im*i: |z| = sqrt(re^2 + im^2).
    double complexAbs(double re, double im);
}
