package ru.mirea.lab4_1.task1;

public class ShapeTest {
    public static void main(String[] args) {
        // Массив объявлен как Shape[], а лежат в нём объекты разных классов. Это и есть "родительская ссылка".
        Shape[] shapes = {
                new Shape(),
                new Circle(3),
                new Rectangle(4, 6),
                new Square(5)
        };

        // Объяснение работы программы:
        // компилятор при вызове shape.getArea() проверяет только то, что такой метод есть у ТИПА ССЫЛКИ (Shape).
        // А вот какой именно код выполнится, JVM решает уже во время работы - по реальному классу объекта
        // (позднее/динамическое связывание). Поэтому один и тот же цикл печатает площадь круга по формуле круга,
        // а квадрата - по формуле, унаследованной от прямоугольника. Это и есть полиморфизм.
        for (Shape shape : shapes) {
            System.out.println("Тип: " + shape.getType());
            System.out.printf("  getArea() = %.2f, getPerimeter() = %.2f%n", shape.getArea(), shape.getPerimeter());
            System.out.println("  toString(): " + shape);
        }

        // Через ссылку Shape нельзя вызвать getRadius() - у Shape такого метода нет, компилятор не пропустит.
        // Нужно сначала убедиться, что это круг, и привести тип (downcast).
        Shape s = shapes[1];
        if (s instanceof Circle circle) {
            System.out.println("\nРадиус круга через downcast: " + circle.getRadius());
        }
    }
}
