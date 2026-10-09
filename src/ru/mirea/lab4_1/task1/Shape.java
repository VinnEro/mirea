package ru.mirea.lab4_1.task1;

// "Простейший" класс фигуры - пока НЕ абстрактный (абстрактный вариант будет в task8).
// У фигуры вообще площадь посчитать нельзя, поэтому базовая реализация честно возвращает 0,
// а настоящие формулы появятся в наследниках через переопределение.
public class Shape {
    public String getType() { return "Фигура"; }
    public double getArea() { return 0; }
    public double getPerimeter() { return 0; }

    // toString написан ОДИН раз в родителе, но внутри он вызывает getType()/getArea()/getPerimeter().
    // Из-за динамического связывания вызовутся версии того класса, каким объект является на самом деле,
    // так что Circle распечатается как круг, хотя toString у Shape.
    @Override
    public String toString() {
        return String.format("%s: площадь = %.2f, периметр = %.2f", getType(), getArea(), getPerimeter());
    }
}
