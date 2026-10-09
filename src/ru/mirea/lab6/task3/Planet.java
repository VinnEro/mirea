package ru.mirea.lab6.task3;

// Планета, машина и животное не имеют общего предка - наследовать их от одного класса было бы странно.
// Но у всех есть имя, и интерфейс позволяет обращаться с ними одинаково, не связывая иерархии.
public class Planet implements Nameable {
    private String name;
    private double radiusKm;

    public Planet(String name, double radiusKm) { this.name = name; this.radiusKm = radiusKm; }

    @Override public String getName() { return "Планета " + name; }
    public double getRadiusKm() { return radiusKm; }
}
