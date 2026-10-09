package ru.mirea.lab6.task5;
import ru.mirea.lab3.task2.Circle;
import ru.mirea.lab6.task1.Movable;

// Окружность из lab3 уже умеет считать длину, площадь, сравниваться - всё это наследуется.
// Мы лишь передаём в родителя MovablePoint как центр (это допустимо: MovablePoint ЯВЛЯЕТСЯ Point).
public class MovableCircle extends Circle implements Movable {
    // Та же ссылка, что лежит в родителе, но с "правильным" типом. Через getCenter() родителя
    // мы получили бы просто Point, и пришлось бы каждый раз делать приведение (MovablePoint) getCenter().
    private MovablePoint center;

    public MovableCircle(double x, double y, double xSpeed, double ySpeed, double radius) {
        this(new MovablePoint(x, y, xSpeed, ySpeed), radius);
    }

    // Отдельный приватный конструктор нужен из-за правила "super(...) - первая строка":
    // точку надо создать ДО вызова super и затем использовать ту же самую ссылку для своего поля.
    private MovableCircle(MovablePoint center, double radius) {
        super(center, radius);
        this.center = center;
    }

    @Override public void moveUp() { center.moveUp(); }
    @Override public void moveDown() { center.moveDown(); }
    @Override public void moveLeft() { center.moveLeft(); }
    @Override public void moveRight() { center.moveRight(); }
}
