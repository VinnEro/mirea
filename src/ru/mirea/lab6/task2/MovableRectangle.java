package ru.mirea.lab6.task2;
import ru.mirea.lab6.task1.Movable;
import ru.mirea.lab6.task1.MovablePoint;

// Интерфейс Movable и MovablePoint берём из task1 через import, а не копируем:
// одна и та же точка используется и в окружности, и в прямоугольнике.
public class MovableRectangle implements Movable {
    private MovablePoint topLeft;
    private MovablePoint bottomRight;

    // Скорость одна на оба угла (xSpeed, ySpeed) - так сказано в UML.
    // Это уже гарантирует, что точки двигаются синхронно и прямоугольник не "растягивается".
    public MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) {
        // Проверяем, что первая точка действительно левая верхняя (ось Y смотрит вниз, см. MovablePoint).
        // Иначе названия полей врали бы, а ширина/высота получились бы отрицательными.
        if (x1 > x2 || y1 > y2) {
            throw new IllegalArgumentException("Точка (x1,y1) должна быть левее и выше точки (x2,y2)");
        }
        topLeft = new MovablePoint(x1, y1, xSpeed, ySpeed);
        bottomRight = new MovablePoint(x2, y2, xSpeed, ySpeed);
    }

    // Метод проверки из задания: "убедитесь, что две точки имеют одну и ту же скорость".
    // Через конструктор разные скорости задать нельзя, но проверка всё равно полезна -
    // это "страховка" на случай, если класс потом расширят (например, добавят конструктор из двух готовых точек).
    public boolean hasSameSpeed() {
        return topLeft.getXSpeed() == bottomRight.getXSpeed()
                && topLeft.getYSpeed() == bottomRight.getYSpeed();
    }

    public int getWidth() { return bottomRight.getX() - topLeft.getX(); }
    public int getHeight() { return bottomRight.getY() - topLeft.getY(); }

    @Override
    public String toString() {
        return "Rectangle: topLeft=" + topLeft + ", bottomRight=" + bottomRight + ", size=" + getWidth() + "x" + getHeight();
    }

    // Двигаем ОБЕ точки. Если бы двигали только одну, прямоугольник менял бы размер, а не положение.
    @Override public void moveUp() { topLeft.moveUp(); bottomRight.moveUp(); }
    @Override public void moveDown() { topLeft.moveDown(); bottomRight.moveDown(); }
    @Override public void moveLeft() { topLeft.moveLeft(); bottomRight.moveLeft(); }
    @Override public void moveRight() { topLeft.moveRight(); bottomRight.moveRight(); }
}
