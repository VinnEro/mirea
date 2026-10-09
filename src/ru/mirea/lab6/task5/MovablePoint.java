package ru.mirea.lab6.task5;
import ru.mirea.lab3.task2.Point;
import ru.mirea.lab6.task1.Movable;

// Задание 5 просит построить MovablePoint/MovableCircle "на основе классов из практической работы 5".
// PDF пятой работы в папке нет, поэтому за основу взяты Point и Circle из lab3.task2 - самые близкие по смыслу классы.
//
// Отличие от task1: там точка писалась с нуля, а здесь она НАСЛЕДУЕТ готовую точку (координаты, toString)
// и только ДОБАВЛЯЕТ скорость и умение двигаться. Это и есть сочетание extends + implements:
// класс может унаследовать один класс и при этом реализовать интерфейсы.
public class MovablePoint extends Point implements Movable {
    private double xSpeed, ySpeed;

    public MovablePoint(double x, double y, double xSpeed, double ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public double getXSpeed() { return xSpeed; }
    public double getYSpeed() { return ySpeed; }

    // Поля x, y в Point приватные, поэтому меняем их только через сеттеры родителя.
    // Это нормально: инкапсуляция работает и для наследников.
    @Override public void moveUp() { setY(getY() - ySpeed); }
    @Override public void moveDown() { setY(getY() + ySpeed); }
    @Override public void moveLeft() { setX(getX() - xSpeed); }
    @Override public void moveRight() { setX(getX() + xSpeed); }

    @Override public String toString() { return super.toString() + String.format(" speed=(%.1f, %.1f)", xSpeed, ySpeed); }
}
