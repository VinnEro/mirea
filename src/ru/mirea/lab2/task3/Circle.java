package ru.mirea.lab2.task3;

public class Circle {
    private Point center;
    private double radius;
    public Circle(Point center, double radius) { this.center = center; this.radius = radius; }
    @Override public String toString() { return "Circle{center=" + center + ", r=" + radius + "}"; }
}