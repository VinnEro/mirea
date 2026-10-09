package ru.mirea.lab7.task1;

public class MovableRectangle implements Movable {
    private MovablePoint topLeft;
    private MovablePoint bottomRight;

    // Основной конструктор - как на диаграмме: одна скорость на весь прямоугольник.
    public MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) {
        this(new MovablePoint(x1, y1, xSpeed, ySpeed), new MovablePoint(x2, y2, xSpeed, ySpeed));
    }

    // Второй конструктор - из двух готовых точек. Именно ради него SpeedTest() и нужен:
    // здесь ничто не мешает передать точки с РАЗНЫМИ скоростями, и тогда при движении
    // прямоугольник начнёт "растягиваться". Поэтому проверяем скорости сразу и отказываемся создавать
    // некорректный объект.
    public MovableRectangle(MovablePoint topLeft, MovablePoint bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
        if (!SpeedTest()) {
            throw new IllegalArgumentException("У углов прямоугольника должна быть одинаковая скорость");
        }
    }

    // Имя метода с большой буквы задано в методичке (обычно в Java методы пишутся с маленькой - speedTest).
    // final - потому что метод вызывается из конструктора: если бы наследник его переопределил,
    // переопределённая версия выполнилась бы раньше, чем инициализируются поля наследника.
    public final boolean SpeedTest() {
        return topLeft.xSpeed == bottomRight.xSpeed && topLeft.ySpeed == bottomRight.ySpeed;
    }

    @Override
    public String toString() { return "MovableRectangle[topLeft=" + topLeft + ", bottomRight=" + bottomRight + "]"; }

    @Override public void moveUp() { topLeft.moveUp(); bottomRight.moveUp(); }
    @Override public void moveDown() { topLeft.moveDown(); bottomRight.moveDown(); }
    @Override public void moveLeft() { topLeft.moveLeft(); bottomRight.moveLeft(); }
    @Override public void moveRight() { topLeft.moveRight(); bottomRight.moveRight(); }
}
