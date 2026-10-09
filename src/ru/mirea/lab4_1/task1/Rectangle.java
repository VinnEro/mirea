package ru.mirea.lab4_1.task1;

public class Rectangle extends Shape {
    // protected, чтобы Square (наследник прямоугольника) видел стороны напрямую.
    protected double width, length;

    public Rectangle(double width, double length) { this.width = width; this.length = length; }
    public double getWidth() { return width; }
    public double getLength() { return length; }

    @Override public String getType() { return "Прямоугольник"; }
    @Override public double getArea() { return width * length; }
    @Override public double getPerimeter() { return 2 * (width + length); }
    @Override public String toString() { return super.toString() + String.format(" (%.2f x %.2f)", width, length); }
}
