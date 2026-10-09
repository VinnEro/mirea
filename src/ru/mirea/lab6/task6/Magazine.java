package ru.mirea.lab6.task6;

// В пункте 9 массив должен содержать "книги и журналы", поэтому журнал тоже нужен, хотя отдельного пункта о нём нет.
public class Magazine implements Printable {
    private String title;
    private int issue;

    public Magazine(String title, int issue) { this.title = title; this.issue = issue; }

    @Override
    public void print() { System.out.printf("Журнал \"%s\", выпуск №%d%n", title, issue); }
}
