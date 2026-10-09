package ru.mirea.lab6.task1;

public class MovableCircle implements Movable {
    private int radius;
    // Ромб на диаграмме - агрегация: окружность содержит точку-центр.
    // Окружность не наследуется от точки, а делегирует ей движение: "двинуть окружность" = "двинуть её центр".
    private MovablePoint center;

    public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
        // Центр создаём сами внутри конструктора (так сказано в UML - на вход приходят числа, а не точка).
        // Значит, никто снаружи не держит ссылку на наш центр и не сможет сдвинуть его "в обход" окружности.
        this.center = new MovablePoint(x, y, xSpeed, ySpeed);
        this.radius = radius;
    }

    @Override
    public String toString() { return "Circle: center=" + center + ", radius=" + radius; }

    // Вся логика движения уже написана в MovablePoint - просто передаём вызов дальше (делегирование).
    @Override public void moveUp() { center.moveUp(); }
    @Override public void moveDown() { center.moveDown(); }
    @Override public void moveLeft() { center.moveLeft(); }
    @Override public void moveRight() { center.moveRight(); }
}
