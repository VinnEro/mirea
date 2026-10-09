package ru.mirea.lab2.task7;

public class BookTest {
    public static void main(String[] args) {
        Bookshelf shelf = new Bookshelf(3);
        shelf.addBook(new Book("Author1", "Book A", 2005));
        shelf.addBook(new Book("Author2", "Book B", 1998));
        shelf.addBook(new Book("Author3", "Book C", 2020));

        System.out.println("Самая ранняя: " + shelf.getEarliestBook().getTitle());
        System.out.println("Самая поздняя: " + shelf.getLatestBook().getTitle());
        shelf.sortByYear();
        System.out.println("После сортировки:");
        shelf.printBooks();
    }
}