package ru.mirea.lab4_1.task10;

public class Car extends Vehicle {
    public Car() { super("Легковой автомобиль", 80, 4.5, 15, 4, 0.5); }

    @Override public String getType() { return "Автомобиль"; }
    // Остановка на 30 минут каждые 300 км - водителю нужно отдыхать.
    @Override protected double getExtraHours(double distanceKm) { return Math.floor(distanceKm / 300) * 0.5; }
}
