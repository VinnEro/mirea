package ru.mirea.lab6.task6;

public class PrintableTest {
    public static void main(String[] args) {
        Printable[] items = {
                new Book("Война и мир", "Л. Н. Толстой", 1869),
                new Magazine("Хакер", 287),
                new Book("Отцы и дети", "И. С. Тургенев", 1862),
                new Magazine("Наука и жизнь", 9),
                new Shop("Читай-город", "Москва, пр-т Вернадского, 78")
        };

        // Цикл ничего не знает о конкретных классах - он вызывает print() у "чего-то печатаемого".
        // Добавим завтра класс Newspaper implements Printable - этот код менять не придётся.
        for (Printable item : items) item.print();
    }
}
