package ru.mirea.lab4_1.task8;

// Упражнение 1: исправленная версия листинга 4.1.3 с объяснением ошибок.
//
// Главная идея: КОМПИЛЯТОР смотрит на тип ССЫЛКИ и разрешает вызывать только те методы, которые у этого типа есть.
// А JVM во время выполнения смотрит на тип ОБЪЕКТА и выбирает переопределённую версию метода
// (динамическое связывание, полиморфизм).
public class ShapeTest {
    public static void main(String[] args) {
        // В листинге "RED" записано типографскими кавычками “RED” - это не строковый литерал Java,
        // такая строка не скомпилируется вообще. Заменено на обычные двойные кавычки.
        Shape s1 = new Circle(5.5, "RED", false);   // Upcast Circle -> Shape
        System.out.println(s1);                 // Circle.toString() - объект на самом деле Circle
        System.out.println(s1.getArea());       // Circle.getArea()
        System.out.println(s1.getPerimeter());  // Circle.getPerimeter()
        System.out.println(s1.getColor());      // Shape.getColor() - он не переопределён, есть только в Shape
        System.out.println(s1.isFilled());
        // ОШИБКА КОМПИЛЯЦИИ: System.out.println(s1.getRadius());
        // У типа Shape нет метода getRadius(). То, что объект внутри - круг, компилятор не учитывает.
        // Исправление - явно привести тип:
        System.out.println(((Circle) s1).getRadius());

        Circle c1 = (Circle) s1;                // Downcast обратно к Circle - безопасен, объект действительно Circle
        System.out.println(c1);
        System.out.println(c1.getArea());
        System.out.println(c1.getPerimeter());
        System.out.println(c1.getColor());
        System.out.println(c1.isFilled());
        System.out.println(c1.getRadius());     // теперь можно: тип ссылки Circle

        // ОШИБКА КОМПИЛЯЦИИ: Shape s2 = new Shape();
        // Shape абстрактный, создать его экземпляр нельзя. Можно только объект конкретного подкласса.
        // Исправление - например, анонимный подкласс или просто конкретная фигура:
        Shape s2 = new Circle();
        System.out.println(s2);

        Shape s3 = new Rectangle(1.0, 2.0, "RED", false);  // Upcast
        System.out.println(s3);
        System.out.println(s3.getArea());
        System.out.println(s3.getPerimeter());
        System.out.println(s3.getColor());
        // ОШИБКА КОМПИЛЯЦИИ: System.out.println(s3.getLength());
        // getLength() есть только у Rectangle. Исправление - downcast:
        System.out.println(((Rectangle) s3).getLength());

        Rectangle r1 = (Rectangle) s3;          // downcast
        System.out.println(r1);
        System.out.println(r1.getArea());
        System.out.println(r1.getColor());
        System.out.println(r1.getLength());

        Shape s4 = new Square(6.6);             // Upcast
        System.out.println(s4);
        System.out.println(s4.getArea());
        System.out.println(s4.getColor());
        // ОШИБКА КОМПИЛЯЦИИ: System.out.println(s4.getSide());  - у Shape нет getSide().
        System.out.println(((Square) s4).getSide());

        // В листинге комментарий закрыт как "*//" - это лишний символ /, после которого строка
        // ломает синтаксис. Ниже он оформлен корректно.
        /* Downcast Shape s4 к Rectangle - суперклассу Square, а не к самому Square.
           Это допустимо: квадрат ЯВЛЯЕТСЯ прямоугольником, поэтому ClassCastException не будет. */
        Rectangle r2 = (Rectangle) s4;
        System.out.println(r2);                 // всё равно Square.toString(): объект-то квадрат
        System.out.println(r2.getArea());
        System.out.println(r2.getColor());
        // ОШИБКА КОМПИЛЯЦИИ: System.out.println(r2.getSide());  - у Rectangle нет getSide().
        System.out.println(((Square) r2).getSide());
        System.out.println(r2.getLength());

        // Downcast Rectangle r2 к Square - тоже корректен во время выполнения, потому что объект - квадрат.
        Square sq1 = (Square) r2;
        System.out.println(sq1);
        System.out.println(sq1.getArea());
        System.out.println(sq1.getColor());
        System.out.println(sq1.getSide());
        System.out.println(sq1.getLength());    // унаследован от Rectangle

        // А вот пример downcast, который компилируется, но падает при выполнении:
        // s3 указывает на Rectangle, а не на Square. Компилятор не может это проверить, проверит только JVM.
        // Поэтому перед рискованным приведением используют instanceof.
        if (s3 instanceof Square) {
            System.out.println("s3 - квадрат");
        } else {
            System.out.println("s3 НЕ квадрат: (Square) s3 бросил бы ClassCastException");
        }

        // Демонстрация, зачем Square переопределяет setWidth: квадрат остаётся квадратом.
        sq1.setWidth(10);
        System.out.println("После sq1.setWidth(10): " + sq1);
    }
}
