package ru.mirea.lab4_1.task5;

public class ReaderTest {
    public static void main(String[] args) {
        Reader[] readers = {
                new Reader("Петров В. В.", 1001, "ИИТ", "12.03.2005", "+7 900 123-45-67"),
                new Reader("Иващенко В. А.", 1002, "ИКБ", "01.09.2006", "+7 900 765-43-21"),
                new Reader("Сидорова А. С.", 1003, "ИТХТ", "25.12.2005", "+7 901 111-11-11")
        };

        for (Reader reader : readers) System.out.println(reader);
        System.out.println();

        Reader petrov = readers[0];
        petrov.takeBook(3);
        petrov.takeBook("Приключения", "Словарь", "Энциклопедия");
        petrov.takeBook(new Book("Приключения", "Марк Твен"), new Book("Словарь", "Ожегов"), new Book("Энциклопедия", "БРЭ"));

        petrov.returnBook(3);
        petrov.returnBook("Приключения", "Словарь", "Энциклопедия");
        petrov.returnBook(new Book("Приключения", "Марк Твен"), new Book("Словарь", "Ожегов"));

        // Проверка склонения на "неудобных" числах.
        readers[1].takeBook(1);
        readers[2].takeBook(11);
        readers[2].returnBook(22);
    }
}
