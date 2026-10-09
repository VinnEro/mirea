// Файл Circle.java
package ru.mirea.lab2.task6;

public class CircleModel {
    private double radius;
    public CircleModel(double radius) { this.radius = radius; }
    public double getRadius() { return radius; }
    public void setRadius(double radius) { this.radius = radius; }
    public double getArea() { return Math.PI * radius * radius; }
    public double getLength() { return 2 * Math.PI * radius; }
    public int compareTo(CircleModel other) { return Double.compare(this.radius, other.radius); }
}