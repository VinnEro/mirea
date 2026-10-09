package ru.mirea.lab4_1.task10;

public class Ship extends Vehicle {
    public Ship() { super("Грузопассажирское судно", 35, 3.0, 1, 400, 20000); }

    @Override public String getType() { return "Корабль"; }
    // Шлюзы и швартовка - 2 часа на старте и финише.
    @Override protected double getExtraHours(double distanceKm) { return 2; }
}
