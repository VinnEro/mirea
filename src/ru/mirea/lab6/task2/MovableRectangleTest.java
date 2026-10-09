package ru.mirea.lab6.task2;
import ru.mirea.lab6.task1.Movable;

public class MovableRectangleTest {
    public static void main(String[] args) {
        MovableRectangle rect = new MovableRectangle(0, 0, 40, 20, 5, 3);
        System.out.println(rect);
        System.out.println("Скорости точек совпадают: " + rect.hasSameSpeed());

        Movable m = rect;   // работаем через интерфейс, как с точкой и окружностью в task1
        m.moveRight();
        m.moveDown();
        System.out.println("После вправо и вниз: " + rect);
        System.out.println("Размер не изменился: " + rect.getWidth() + "x" + rect.getHeight());

        try {
            new MovableRectangle(10, 10, 0, 0, 1, 1);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
