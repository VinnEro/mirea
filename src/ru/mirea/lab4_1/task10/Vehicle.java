package ru.mirea.lab4_1.task10;

// Абстрактное транспортное средство. Формулы времени и стоимости одинаковы для всех
// (время = расстояние / скорость, стоимость = тариф * расстояние * количество), поэтому они реализованы здесь,
// а наследники только задают свои параметры и особенности (посадка, стоянка, сборы).
public abstract class Vehicle {
    protected String name;
    protected double speed;                 // км/ч
    protected double pricePerPassengerKm;   // руб. за 1 пассажира на 1 км
    protected double pricePerTonKm;         // руб. за 1 тонну груза на 1 км
    protected int maxPassengers;
    protected double maxCargoTons;

    public Vehicle(String name, double speed, double pricePerPassengerKm, double pricePerTonKm, int maxPassengers, double maxCargoTons) {
        this.name = name;
        this.speed = speed;
        this.pricePerPassengerKm = pricePerPassengerKm;
        this.pricePerTonKm = pricePerTonKm;
        this.maxPassengers = maxPassengers;
        this.maxCargoTons = maxCargoTons;
    }

    public String getName() { return name; }

    // Каждый вид транспорта тратит время ещё и "вне движения": регистрация в аэропорту, стоянки поезда и т.д.
    // Это различается у разных видов - поэтому абстрактный метод.
    protected abstract double getExtraHours(double distanceKm);

    public abstract String getType();

    public double getTravelTime(double distanceKm) {
        return distanceKm / speed + getExtraHours(distanceKm);
    }

    // Если пассажиров больше, чем мест, понадобится несколько рейсов. Деление с округлением вверх:
    // 5 пассажиров при 4 местах - это 2 рейса, а не 1.25. Math.ceil как раз округляет вверх.
    public int getTrips(int passengers) {
        return (int) Math.ceil((double) passengers / maxPassengers);
    }

    public double getPassengerCost(double distanceKm, int passengers) {
        return passengers * distanceKm * pricePerPassengerKm;
    }

    public double getCargoCost(double distanceKm, double tons) {
        return tons * distanceKm * pricePerTonKm;
    }

    public int getCargoTrips(double tons) {
        return (int) Math.ceil(tons / maxCargoTons);
    }
}
