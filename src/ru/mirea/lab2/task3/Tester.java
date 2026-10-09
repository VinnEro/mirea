package ru.mirea.lab2.task3;

public class Tester {
    private Circle[] circles;
    private int count = 0;

    public Tester(int size) { circles = new Circle[size]; }
    public void addCircle(Circle circle) { if (count < circles.length) circles[count++] = circle; }
    public void printCircles() { for (int i = 0; i < count; i++) System.out.println(circles[i]); }

    public static void main(String[] args) {
        Tester tester = new Tester(3);
        tester.addCircle(new Circle(new Point(0, 0), 5.0));
        tester.addCircle(new Circle(new Point(2, 3), 10.0));
        tester.printCircles();
    }
}