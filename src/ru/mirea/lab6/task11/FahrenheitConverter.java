package ru.mirea.lab6.task11;

public class FahrenheitConverter implements Convertable {
    // 9.0 / 5, а не 9 / 5: деление двух int дало бы 1 (дробная часть отбрасывается), и формула бы сломалась.
    @Override public double convert(double celsius) { return celsius * 9.0 / 5 + 32; }
    @Override public String getUnit() { return "°F"; }
}
