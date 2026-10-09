package ru.mirea.lab6.task3;

public class Car implements Nameable {
    private String brand;
    private String model;

    public Car(String brand, String model) { this.brand = brand; this.model = model; }

    // "Имя" машины собирается из двух полей - интерфейсу всё равно, как именно оно получено.
    @Override public String getName() { return "Автомобиль " + brand + " " + model; }
}
