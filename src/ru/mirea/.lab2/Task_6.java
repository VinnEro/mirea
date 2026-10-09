package ru.mirea.lab2;

public class Task_6 {
    public static void main(String[] args) {
        CircleModel c1 = new CircleModel(7.0);
        CircleModel c2 = new CircleModel(7.0);

        System.out.println("Площадь c1: " + c1.getArea());
        System.out.println("Длина c1: " + c1.getLength());
        System.out.println("Сравнение c1 и c2: " + c1.compareTo(c2));
    }
}

class CircleModel {
    private double radius;

    public CircleModel(double radius) { this.radius = radius; }
    public double getRadius() { return radius; }
    public void setRadius(double radius) { this.radius = radius; }

    public double getArea() { return Math.PI * radius * radius; }
    public double getLength() { return 2 * Math.PI * radius; }

    public int compareTo(CircleModel other) {
        return Double.compare(this.radius, other.radius);
    }
}