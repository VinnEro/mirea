package ru.mirea.lab4_1.task9;

// Абстрактная мебель: у любого предмета мебели есть название, материал и цена,
// но "собрать" её можно только конкретную - стул, стол, шкаф.
public abstract class Furniture {
    protected String name;
    protected String material;
    protected double price;

    public Furniture(String name, String material, double price) {
        this.name = name;
        this.material = material;
        this.price = price;
    }

    public String getName() { return name; }
    public String getMaterial() { return material; }
    public double getPrice() { return price; }

    // У каждого вида мебели своё назначение - общего ответа нет, поэтому метод абстрактный.
    public abstract String getPurpose();

    // Доставка зависит от габаритов, а габариты знает только конкретный класс.
    // По умолчанию считаем 5% от цены; крупная мебель переопределит этот метод.
    public double getDeliveryCost() { return price * 0.05; }

    @Override
    public String toString() {
        return String.format("%-12s %-18s %-8s %,10.2f руб. (доставка %,.2f) - %s",
                getClass().getSimpleName(), name, material, price, getDeliveryCost(), getPurpose());
    }
}
