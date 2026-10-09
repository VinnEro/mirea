package ru.mirea.lab4_1.task10;

public class VehicleTest {
    public static void main(String[] args) {
        Vehicle[] vehicles = {new Car(), new Plane(), new Train(), new Ship()};

        double distance = 1200;     // км
        int passengers = 50;
        double cargo = 30;          // тонн

        System.out.printf("Расстояние %.0f км, пассажиров %d, груз %.0f т%n%n", distance, passengers, cargo);
        System.out.printf("%-11s %9s %16s %7s %16s %7s%n", "Транспорт", "Время, ч", "Пассажиры, руб.", "Рейсов", "Груз, руб.", "Рейсов");

        // Один и тот же цикл для всех видов транспорта - конкретная логика подставляется полиморфно.
        for (Vehicle v : vehicles) {
            System.out.printf("%-11s %9.1f %,16.2f %7d %,16.2f %7d%n",
                    v.getType(),
                    v.getTravelTime(distance),
                    v.getPassengerCost(distance, passengers),
                    v.getTrips(passengers),
                    v.getCargoCost(distance, cargo),
                    v.getCargoTrips(cargo));
        }
    }
}
