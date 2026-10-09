package ru.mirea.lab7.task1;

public class MovableRectangleTest {
    public static void main(String[] args) {
        MovableRectangle rect = new MovableRectangle(0, 0, 10, 5, 2, 1);
        System.out.println(rect);
        System.out.println("SpeedTest(): " + rect.SpeedTest());

        Movable m = rect;
        m.moveRight();
        m.moveRight();
        m.moveDown();
        System.out.println("После 2x вправо и вниз: " + rect);
        m.moveLeft();
        m.moveUp();
        System.out.println("После влево и вверх:    " + rect);

        // Точки с разной скоростью - конструктор не даст собрать такой прямоугольник.
        try {
            new MovableRectangle(new MovablePoint(0, 0, 1, 1), new MovablePoint(5, 5, 3, 1));
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
