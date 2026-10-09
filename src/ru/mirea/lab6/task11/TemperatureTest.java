package ru.mirea.lab6.task11;
import java.util.Scanner;

public class TemperatureTest {
    public static void main(String[] args) {
        Convertable[] converters = {new KelvinConverter(), new FahrenheitConverter()};

        Scanner sc = new Scanner(System.in);
        System.out.print("Введите температуру по Цельсию: ");
        // nextDouble() зависит от локали (на русской ждёт "36,6"), поэтому парсим сами и принимаем и точку, и запятую.
        double celsius = Double.parseDouble(sc.next().replace(',', '.'));

        // Температура ниже абсолютного нуля физически невозможна - не будем делать вид, что её можно перевести.
        if (celsius < KelvinConverter.ABSOLUTE_ZERO_C) {
            System.out.println("Ниже абсолютного нуля не бывает.");
            return;
        }

        for (Convertable c : converters) {
            System.out.printf("%.2f °C = %.2f %s%n", celsius, c.convert(celsius), c.getUnit());
        }

        // Короткая таблица для проверки формул на известных точках (замерзание и кипение воды).
        System.out.println("\n   °C        K       °F");
        for (double t : new double[]{-40, 0, 36.6, 100}) {
            System.out.printf("%6.1f %8.2f %8.2f%n", t, converters[0].convert(t), converters[1].convert(t));
        }
    }
}
