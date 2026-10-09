package ru.mirea.lab6.task3;

public class NameableTest {
    public static void main(String[] args) {
        Nameable[] things = {
                new Planet("Земля", 6371),
                new Car("Lada", "Vesta"),
                new Animal("Кот", "Барсик"),
                // Анонимный класс: реализуем интерфейс "на месте", когда отдельный класс ради одного объекта не нужен.
                new Nameable() {
                    @Override public String getName() { return "Безымянный объект (анонимный класс)"; }
                }
        };

        for (Nameable n : things) System.out.println(n.getName());
    }
}
