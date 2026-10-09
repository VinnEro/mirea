package ru.mirea.lab7.task1;

public class MovablePoint implements Movable {
    // package-private: MovableRectangle лежит в этом же пакете и может читать скорости напрямую для SpeedTest().
    int x, y;
    int xSpeed, ySpeed;

    // Параметризованный конструктор (пункт 3).
    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    // Метод "перевода числовых значений в строку" из пункта 3 - это и есть toString().
    @Override
    public String toString() { return "(" + x + ", " + y + ") v=(" + xSpeed + ", " + ySpeed + ")"; }

    // Экранная система координат: y растёт вниз, поэтому "вверх" = y уменьшается.
    @Override public void moveUp() { y -= ySpeed; }
    @Override public void moveDown() { y += ySpeed; }
    @Override public void moveLeft() { x -= xSpeed; }
    @Override public void moveRight() { x += xSpeed; }
}
