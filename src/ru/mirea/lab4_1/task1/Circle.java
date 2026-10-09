package ru.mirea.lab4_1.task1;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) { this.radius = radius; }
    public double getRadius() { return radius; }

    @Override public String getType() { return "Круг"; }
    @Override public double getArea() { return Math.PI * radius * radius; }
    @Override public double getPerimeter() { return 2 * Math.PI * radius; }

    // super.toString() даёт общую часть, а мы дописываем то, что есть только у круга - радиус.
    @Override public String toString() { return super.toString() + String.format(" (r = %.2f)", radius); }
}
