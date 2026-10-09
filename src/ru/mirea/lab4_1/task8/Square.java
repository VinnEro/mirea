package ru.mirea.lab4_1.task8;

// По диаграмме Square наследуется от Rectangle и своих полей не имеет:
// сторона квадрата хранится в унаследованных width и length, которые всегда должны быть равны.
public class Square extends Rectangle {
    public Square() { this(1.0); }
    public Square(double side) { super(side, side); }
    public Square(double side, String color, boolean filled) { super(side, side, color, filled); }

    public double getSide() { return width; }

    public void setSide(double side) {
        // Обращаемся к полям напрямую, а не через setWidth/setLength, чтобы не уйти в лишние вызовы
        // переопределённых методов ниже.
        this.width = side;
        this.length = side;
    }

    // Зачем переопределять setWidth и setLength? Без этого можно было бы написать square.setWidth(10),
    // и квадрат стал бы прямоугольником 10 x 6.6 - объект оказался бы в "невозможном" состоянии.
    // Поэтому любая попытка поменять одну сторону меняет обе.
    // (Это, кстати, классический пример нарушения принципа подстановки Лисков, но диаграмма требует именно так.)
    @Override public void setWidth(double side) { setSide(side); }
    @Override public void setLength(double side) { setSide(side); }

    @Override public String toString() { return "Square[" + super.toString() + "]"; }
}
