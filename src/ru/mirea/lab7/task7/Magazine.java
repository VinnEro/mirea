package ru.mirea.lab7.task7;

public class Magazine implements Printable {
    private String name;

    public Magazine(String name) { this.name = name; }
    public String getName() { return name; }

    @Override
    public void print() { System.out.printf("Журнал '%s'%n", name); }

    // Пункт 7 - то же самое, что printBooks, только фильтр по журналам.
    public static void printMagazines(Printable[] printable) {
        for (Printable p : printable) {
            if (p instanceof Magazine magazine) System.out.println(magazine.getName());
        }
    }
}
