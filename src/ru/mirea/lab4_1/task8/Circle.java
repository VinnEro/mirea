package ru.mirea.lab4_1.task8;

public class Circle extends Shape {
    protected double radius;

    // Конструктор по умолчанию: радиус 1, а цвет и заливку берёт конструктор Shape() по умолчанию.
    public Circle() { this.radius = 1.0; }
    public Circle(double radius) { this.radius = radius; }
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() { return radius; }
    public void setRadius(double radius) { this.radius = radius; }

    @Override public double getArea() { return Math.PI * radius * radius; }
    @Override public double getPerimeter() { return 2 * Math.PI * radius; }

    @Override public String toString() { return "Circle[" + super.toString() + ", radius=" + radius + "]"; }
}
