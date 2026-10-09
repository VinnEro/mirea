package ru.mirea.lab4.task2;

// Абстрактный, потому что "просто одежды" не бывает - бывает футболка, юбка, галстук.
// Но размер, цена и цвет есть у любой вещи, поэтому они вынесены сюда, чтобы не дублировать их в четырёх классах.
public abstract class Clothes {
    // protected - чтобы наследники могли обращаться к полям напрямую при выводе информации о себе.
    protected Size size;
    protected double cost;
    protected String color;

    public Clothes(Size size, double cost, String color) {
        this.size = size;
        this.cost = cost;
        this.color = color;
    }

    public Size getSize() { return size; }
    public double getCost() { return cost; }
    public String getColor() { return color; }

    // Общая часть описания. Название вещи у каждого класса своё, поэтому берём его через абстрактный метод.
    public abstract String getName();

    @Override
    public String toString() {
        return String.format("%-8s размер %-3s (EU %d, %s), цвет: %-7s цена: %.2f руб.",
                getName(), size, size.getEuroSize(), size.getDescription(), color, cost);
    }
}
