package ru.mirea.lab4_1.task10;

public class Train extends Vehicle {
    public Train() { super("Поезд дальнего следования", 90, 2.5, 3, 600, 3000); }

    @Override public String getType() { return "Поезд"; }
    // Стоянки на станциях: примерно 15 минут на каждые 200 км.
    @Override protected double getExtraHours(double distanceKm) { return Math.floor(distanceKm / 200) * 0.25; }
}
