package ru.mirea.lab3.wrappers.task1;

public class DoubleWrapper {
    public static void main(String[] args) {
        // 1. Создание объектов Double через valueOf().
        // Конструктор new Double(...) помечен как deprecated (с Java 9) и вот-вот будет удалён,
        // поэтому правильный способ - фабричный метод valueOf(). Он умеет принимать и double, и строку.
        Double d1 = Double.valueOf(3.14);
        Double d2 = Double.valueOf("2.718");
        System.out.println("d1 = " + d1 + ", d2 = " + d2);

        // 2. Строка -> примитив double.
        // Отличие от valueOf: parseDouble возвращает именно примитив double, а не объект Double.
        // Если нам нужен просто числовой результат для вычислений - parseDouble дешевле, без лишнего объекта.
        double parsed = Double.parseDouble("123.456");
        System.out.println("parseDouble(\"123.456\") = " + parsed);

        // 3. Double -> все примитивные типы.
        // Эти методы унаследованы от абстрактного класса Number. При переходе к целым типам
        // дробная часть просто ОТБРАСЫВАЕТСЯ (а не округляется), а для byte/short ещё и возможно
        // переполнение - поэтому берём число, на котором это хорошо видно.
        Double big = Double.valueOf(300.99);
        byte b = big.byteValue();       // 300 не влезает в byte (-128..127): 300 - 256 = 44
        short s = big.shortValue();
        int i = big.intValue();         // 300, дробная часть потеряна
        long l = big.longValue();
        float f = big.floatValue();     // float точнее чем int, но грубее чем double
        double d = big.doubleValue();   // "распаковка" обратно в тот же примитив
        // В boolean и char Double не преобразуется вообще - таких методов у Number нет,
        // так что для полноты делаем это "по смыслу" вручную.
        boolean bool = big != 0.0;
        char c = (char) big.intValue();

        System.out.println("byteValue()   = " + b + "   <- переполнение byte");
        System.out.println("shortValue()  = " + s);
        System.out.println("intValue()    = " + i + "  <- дробная часть отброшена");
        System.out.println("longValue()   = " + l);
        System.out.println("floatValue()  = " + f);
        System.out.println("doubleValue() = " + d);
        System.out.println("boolean (вручную, != 0) = " + bool);
        System.out.println("char (вручную, код 300) = " + c);

        // 4. Вывод объекта Double. println сам вызовет toString(), отдельно вызывать не надо.
        System.out.println("Объект Double: " + big);

        // 5. Литерал double -> String через статический toString(double).
        String str = Double.toString(3.14);
        System.out.println("Double.toString(3.14) = \"" + str + "\", длина строки: " + str.length());
    }
}
