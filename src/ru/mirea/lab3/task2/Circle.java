package ru.mirea.lab3.task2;

public class Circle {
    private Point center;
    private double radius;
    // Длину окружности храним отдельным полем, потому что так просит задание
    // ("инициализация полей радиуса и длины окружности"). Но важно, чтобы она
    // никогда не "разъехалась" с радиусом - поэтому меняем её только в applyRadius().
    private double length;

    public Circle(Point center, double radius) {
        this.center = center;
        // Вызываем приватный метод, а не публичный setRadius(): публичный метод может переопределить наследник
        // (например, MovableCircle из lab6), и тогда из конструктора вызвался бы код ещё не созданного подкласса.
        applyRadius(radius);
    }

    public Point getCenter() { return center; }
    public void setCenter(Point center) { this.center = center; }
    public double getRadius() { return radius; }
    public double getLength() { return length; }

    // Единственное место, где меняется радиус (applyRadius ниже). Если бы length пересчитывалась где-то ещё,
    // рано или поздно кто-нибудь забыл бы это сделать и получил бы окружность с неправильной длиной.
    public void setRadius(double radius) { applyRadius(radius); }

    private void applyRadius(double radius) {
        this.radius = radius;
        this.length = 2 * Math.PI * radius;
    }

    public double getArea() { return Math.PI * radius * radius; }

    // Сравниваем по радиусу: у окружностей больше радиус = больше и площадь, и длина,
    // так что отдельно сравнивать площади не нужно. Double.compare вместо "this.radius - other.radius",
    // потому что разность double нельзя просто привести к int - 0.3 превратится в 0 и окружности "сравняются".
    public int compareTo(Circle other) { return Double.compare(this.radius, other.radius); }

    @Override public String toString() {
        return String.format("Circle{center=%s, r=%.2f, length=%.2f}", center, radius, length);
    }
}
