package ru.mirea.lab2;

public class Task_2 {
    public static void main(String[] args) {
        Ball ball = new Ball(10.5, 5.2);
        System.out.println(ball.toString());
        ball.move(2.0, -1.0);
        System.out.println("После перемещения: " + ball.toString());
    }
}

class Ball {
    private double x = 0.0;
    private double y = 0.0;

    public Ball(double x, double y) { this.x = x; this.y = y; }

    public double getX() { return x; }
    public void setX(double x) { this.x = x; }
    public double getY() { return y; }
    public void setY(double y) { this.y = y; }
    public void setXY(double x, double y) { this.x = x; this.y = y; }

    public void move(double xDisp, double yDisp) {
        this.x += xDisp;
        this.y += yDisp;
    }

    @Override
    public String toString() {
        return "Ball{x=" + x + ", y=" + y + "}";
    }
}