package ru.mirea.lab6.task11;

public class KelvinConverter implements Convertable {
    // Абсолютный ноль = -273.15 °C. Константа с именем понятнее, чем "магическое" число в формуле.
    public static final double ABSOLUTE_ZERO_C = -273.15;

    @Override public double convert(double celsius) { return celsius - ABSOLUTE_ZERO_C; }
    @Override public String getUnit() { return "K"; }
}
