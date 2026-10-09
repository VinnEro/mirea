package ru.mirea.lab7.task7;

public class PrintableTest {
    public static void main(String[] args) {
        Printable[] printable = {
                new Book("Война и мир", "Л. Н. Толстой", 1863),
                new Magazine("Хакер"),
                new Book("Отцы и дети", "И. Тургенев", 1862),
                new Magazine("Компьютерра"),
                new Magazine("Наука и жизнь")
        };

        System.out.println("Всё подряд (полиморфный вызов print()):");
        for (Printable p : printable) p.print();

        // Статические методы вызываются через имя класса, а не через объект.
        System.out.println("\nТолько журналы:");
        Magazine.printMagazines(printable);

        System.out.println("\nТолько книги:");
        Book.printBooks(printable);
    }
}
