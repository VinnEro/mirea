package ru.mirea.lab6.task6;

public class Book implements Printable {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) { this.title = title; this.author = author; this.year = year; }

    @Override
    public void print() { System.out.printf("Книга \"%s\" (автор %s), %d год%n", title, author, year); }
}
