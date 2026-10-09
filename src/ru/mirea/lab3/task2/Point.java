package ru.mirea.lab3.task2;

// Точка взята из lab2.task3, но теперь у неё есть геттеры и сеттеры:
// в lab6 (задание 5) от этого класса наследуется MovablePoint, и ему нужно уметь сдвигать координаты.
public class Point {
    private double x, y;

    public Point(double x, double y) { this.x = x; this.y = y; }

    public double getX() { return x; }
    public void setX(double x) { this.x = x; }
    public double getY() { return y; }
    public void setY(double y) { this.y = y; }

    @Override public String toString() { return String.format("(%.1f, %.1f)", x, y); }
}
