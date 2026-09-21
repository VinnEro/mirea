package ru.mirea.lab2;

public class Task_3 {
    public static void main(String[] args) {
        Tester tester = new Tester(3);
        tester.addCircle(new Circle(new Point(0, 0), 5.0));
        tester.addCircle(new Circle(new Point(2, 3), 10.0));
        tester.printCircles();
    }
}

class Point {
    private double x, y;
    public Point(double x, double y) { this.x = x; this.y = y; }
    @Override public String toString() { return "(" + x + ", " + y + ")"; }
}

class Circle {
    private Point center;
    private double radius;
    public Circle(Point center, double radius) { this.center = center; this.radius = radius; }
    @Override public String toString() { return "Circle{center=" + center + ", r=" + radius + "}"; }
}

class Tester {
    private Circle[] circles;
    private int count;

    public Tester(int size) {
        circles = new Circle[size];
        count = 0;
    }

    public void addCircle(Circle circle) {
        if (count < circles.length) {
            circles[count++] = circle;
        }
    }

    public void printCircles() {
        for (int i = 0; i < count; i++) {
            System.out.println(circles[i]);
        }
    }
}