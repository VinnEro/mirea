package ru.mirea.lab6.task1;

// Интерфейс описывает только "что умеет" объект - двигаться в четыре стороны,
// но ничего не говорит о том, "как". Точка, окружность, прямоугольник двигаются по-разному внутри,
// а снаружи их можно двигать одинаково - через ссылку Movable.
public interface Movable {
    void moveUp();
    void moveDown();
    void moveLeft();
    void moveRight();
}
