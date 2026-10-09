package ru.mirea.lab6.task5;
import ru.mirea.lab6.task1.Movable;

public class MovableTest {
    public static void main(String[] args) {
        MovableCircle circle = new MovableCircle(0, 0, 1.5, 2, 10);
        MovablePoint point = new MovablePoint(3, 4, 1, 1);

        Movable[] objects = {point, circle};
        for (Movable m : objects) {
            System.out.println("До:    " + m);
            m.moveRight();
            m.moveDown();
            System.out.println("После: " + m);
        }

        // Методы, унаследованные от lab3.task2.Circle, работают без изменений.
        System.out.printf("Площадь круга: %.2f, сравнение с радиусом 5: %d%n",
                circle.getArea(), circle.compareTo(new ru.mirea.lab3.task2.Circle(point, 5)));
    }
}
