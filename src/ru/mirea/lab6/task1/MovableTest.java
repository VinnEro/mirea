package ru.mirea.lab6.task1;

public class MovableTest {
    public static void main(String[] args) {
        // Тип переменных - интерфейс. Нам неважно, точка это или окружность: важно, что оно двигается.
        Movable point = new MovablePoint(5, 6, 10, 15);
        Movable circle = new MovableCircle(1, 2, 3, 4, 20);

        Movable[] objects = {point, circle};
        for (Movable m : objects) {
            System.out.println("Начало:        " + m);
            m.moveLeft();
            System.out.println("После влево:   " + m);
            m.moveDown();
            System.out.println("После вниз:    " + m);
            m.moveRight();
            m.moveUp();
            System.out.println("Вправо и вверх: " + m + "  <- вернулись в исходную точку");
            System.out.println();
        }
    }
}
