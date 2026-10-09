package ru.mirea.lab4_1.task8;

// Абстрактная версия Shape из task1, строго по UML-диаграмме 4.1.1.
// abstract означает: создать "просто фигуру" через new Shape() нельзя (это ошибка компиляции),
// и у getArea()/getPerimeter() здесь нет тела - каждый наследник ОБЯЗАН их реализовать.
// В task1 мы возвращали 0 для площади "абстрактной" фигуры, что по сути было неправдой; теперь компилятор
// сам не даст забыть реализовать формулу.
public abstract class Shape {
    // # на диаграмме = protected: доступны наследникам (и классам этого же пакета).
    protected String color;
    protected boolean filled;

    public Shape() {
        this("red", true);
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    // Для boolean-геттера принято имя isXxx, а не getXxx - так и на диаграмме: isFilled().
    public boolean isFilled() { return filled; }
    public void setFilled(boolean filled) { this.filled = filled; }

    public abstract double getArea();
    public abstract double getPerimeter();

    @Override
    public String toString() { return "Shape[color=" + color + ", filled=" + filled + "]"; }
}
