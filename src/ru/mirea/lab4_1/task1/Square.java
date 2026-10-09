package ru.mirea.lab4_1.task1;

// Квадрат - частный случай прямоугольника с равными сторонами, поэтому наследуемся от Rectangle,
// а не от Shape: площадь и периметр уже правильно считаются в родителе, переписывать формулы не нужно.
public class Square extends Rectangle {
    public Square(double side) { super(side, side); }
    public double getSide() { return width; }

    @Override public String getType() { return "Квадрат"; }
    // getArea() и getPerimeter() НЕ переопределяем специально - формулы прямоугольника подходят и квадрату.
    @Override public String toString() { return String.format("%s: площадь = %.2f, периметр = %.2f (сторона %.2f)", getType(), getArea(), getPerimeter(), width); }
}
