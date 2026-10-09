package ru.mirea.lab7.task7;

public class Book implements Printable {
    private String name;
    private String author;
    private int year;

    public Book(String name, String author, int year) { this.name = name; this.author = author; this.year = year; }
    public String getName() { return name; }

    @Override
    public void print() { System.out.printf("Книга '%s' (автор %s) была издана в %d году%n", name, author, year); }

    // Пункт 8. Метод статический, потому что он работает не с одной конкретной книгой,
    // а с целым массивом "чего-то печатаемого" - ему не нужен объект Book для вызова.
    // В массиве Printable[] могут лежать и журналы, поэтому сначала проверяем instanceof,
    // и только потом приводим тип: иначе (Book) журнала бросил бы ClassCastException.
    public static void printBooks(Printable[] printable) {
        for (Printable p : printable) {
            if (p instanceof Book book) System.out.println(book.getName());
        }
    }
}
