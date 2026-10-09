package ru.mirea.lab4_1.task10;

public class Plane extends Vehicle {
    public Plane() { super("Пассажирский самолёт", 800, 7.0, 40, 180, 20); }

    @Override public String getType() { return "Самолёт"; }
    // Регистрация, досмотр и дорога до аэропорта - около 3 часов вне зависимости от расстояния.
    @Override protected double getExtraHours(double distanceKm) { return 3; }

    // Аэропортовый сбор - фиксированная доплата за каждого пассажира.
    @Override public double getPassengerCost(double distanceKm, int passengers) {
        return super.getPassengerCost(distanceKm, passengers) + 1500 * passengers;
    }
}
