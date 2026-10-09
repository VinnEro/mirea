package ru.mirea.lab4.task3;

// Каталоги - это фиксированный набор, известный заранее, поэтому это enum, а не строки.
// Со строками легко опечататься ("Электронника"), а с enum компилятор не даст сослаться на несуществующий каталог.
public enum Catalog {
    ELECTRONICS("Электроника"),
    BOOKS("Книги"),
    CLOTHES("Одежда");

    private final String title;

    Catalog(String title) { this.title = title; }

    public String getTitle() { return title; }
}
