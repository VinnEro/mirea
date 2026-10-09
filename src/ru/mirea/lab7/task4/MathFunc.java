package ru.mirea.lab7.task4;

public class MathFunc implements MathCalculable {

    // Возведение в целую степень написано вручную (а не через Math.pow), чтобы было что реализовывать.
    // Используется быстрое возведение в степень: на каждом шаге показатель делится пополам,
    // поэтому x^1000 считается за ~10 умножений вместо 1000.
    @Override
    public double pow(double base, int exponent) {
        // Отрицательная степень: x^(-n) = 1 / x^n. long - чтобы -Integer.MIN_VALUE не переполнился.
        long n = exponent;
        if (n < 0) {
            base = 1 / base;
            n = -n;
        }
        double result = 1;
        while (n > 0) {
            if (n % 2 == 1) result *= base;     // нечётный показатель - "забираем" один множитель
            base *= base;
            n /= 2;
        }
        return result;
    }

    @Override
    public double complexAbs(double re, double im) {
        // Используем свой pow, чтобы методы интерфейса работали в связке.
        return Math.sqrt(pow(re, 2) + pow(im, 2));
    }

    // Пример использования константы PI из интерфейса - доступна без префикса, потому что класс её реализует.
    public double circleLength(double radius) { return 2 * PI * radius; }

    public double circleArea(double radius) { return PI * pow(radius, 2); }
}
