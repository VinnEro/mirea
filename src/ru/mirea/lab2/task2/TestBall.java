package ru.mirea.lab2.task2;

public class TestBall {
    public static void main(String[] args) {
        Ball ball = new Ball(10.5, 5.2);
        System.out.println(ball.toString());
        ball.move(2.0, -1.0);
        System.out.println("После перемещения: " + ball.toString());
    }
}