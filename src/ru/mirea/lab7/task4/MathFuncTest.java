package ru.mirea.lab7.task4;

public class MathFuncTest {
    public static void main(String[] args) {
        MathCalculable mc1 = new MathFunc();    // правильно: ссылка-интерфейс на объект реализации
        // MathCalculable mc2 = new MathCalculable();
        // ^ ошибка компиляции: интерфейс не является классом, у него нет конструктора и реализации методов.

        System.out.println("2^10 = " + mc1.pow(2, 10));
        System.out.println("2^-2 = " + mc1.pow(2, -2));
        System.out.println("1.5^0 = " + mc1.pow(1.5, 0));
        System.out.println("|3 + 4i| = " + mc1.complexAbs(3, 4));
        System.out.println("PI из интерфейса: " + MathCalculable.PI);

        // circleLength нет в интерфейсе - через ссылку MathCalculable его не вызвать, нужен тип MathFunc.
        MathFunc func = (MathFunc) mc1;
        System.out.printf("Длина окружности r=5: %.4f%n", func.circleLength(5));
        System.out.printf("Площадь круга r=5:    %.4f%n", func.circleArea(5));

        // Сверяемся со стандартной библиотекой, чтобы убедиться, что собственная реализация не ошибается.
        System.out.println("Совпадает с Math.pow(3, 7): " + (mc1.pow(3, 7) == Math.pow(3, 7)));
    }
}
