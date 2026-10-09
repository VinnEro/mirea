package ru.mirea.lab6.task1;

public class MovablePoint implements Movable {
    // На диаграмме у полей значок ~ - это package-private (без модификатора):
    // видны классам этого же пакета (например, MovableCircle), но не всему миру.
    int x;
    int y;
    int xSpeed;
    int ySpeed;

    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    // Геттеров на диаграмме нет, но без них класс из ДРУГОГО пакета (MovableRectangle в task2)
    // не смог бы узнать координаты и скорость: package-private поля оттуда не видны.
    public int getX() { return x; }
    public int getY() { return y; }
    public int getXSpeed() { return xSpeed; }
    public int getYSpeed() { return ySpeed; }

    @Override
    public String toString() { return "(" + x + "," + y + "), speed=(" + xSpeed + "," + ySpeed + ")"; }

    // Ось Y направлена ВНИЗ, как на экране компьютера: (0,0) - левый верхний угол.
    // Поэтому "вверх" - это уменьшение y. Так же устроены координаты в Swing/JavaFX.
    @Override public void moveUp() { y -= ySpeed; }
    @Override public void moveDown() { y += ySpeed; }
    @Override public void moveLeft() { x -= xSpeed; }
    @Override public void moveRight() { x += xSpeed; }
}
