package ru.mirea.lab2.task7;

public class Book {
    private String author, title;
    private int year;

    public Book(String author, String title, int year) { this.author = author; this.title = title; this.year = year; }
    public int getYear() { return year; }
    public String getTitle() { return title; }
    @Override public String toString() { return title + " (" + year + ")"; }
}