package ru.mirea.lab2;

public class Task_7 {
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

class Book {
    private String author, title;
    private int year;
    public Book(String author, String title, int year) { this.author = author; this.title = title; this.year = year; }
    public int getYear() { return year; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    @Override public String toString() { return author + "\"" + title + "\" " + " (" + year + ")"; }
}

class Bookshelf {
    private Book[] books;
    private int count = 0;

    public Bookshelf(int capacity) { books = new Book[capacity]; }

    public void addBook(Book book) {
        if (count < books.length) books[count++] = book;
    }

    public Book getEarliestBook() {
        Book earliest = books[0];
        for (int i = 1; i < count; i++) {
            if (books[i].getYear() < earliest.getYear()) earliest = books[i];
        }
        return earliest;
    }

    public Book getLatestBook() {
        Book latest = books[0];
        for (int i = 1; i < count; i++) {
            if (books[i].getYear() > latest.getYear()) latest = books[i];
        }
        return latest;
    }

    public void sortByYear() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (books[j].getYear() > books[j + 1].getYear()) {
                    Book temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;
                }
            }
        }
    }

    public void printBooks() {
        for (int i = 0; i < count; i++) System.out.println(books[i]);
    }
}