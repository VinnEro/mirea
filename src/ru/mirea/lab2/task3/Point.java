package ru.mirea.lab2.task3;

public class Point {
    private double x, y;
    public Point(double x, double y) { this.x = x; this.y = y; }
    @Override public String toString() { return "(" + x + ", " + y + ")"; }
}