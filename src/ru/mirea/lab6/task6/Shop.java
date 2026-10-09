package ru.mirea.lab6.task6;

// Магазин тоже Printable - хотя с книгой у него нет ничего общего, кроме умения "распечатать себя".
// Именно в этом сила интерфейса: общее поведение без общего предка.
public class Shop implements Printable {
    private String name;
    private String address;

    public Shop(String name, String address) { this.name = name; this.address = address; }

    @Override
    public void print() { System.out.println("Магазин \"" + name + "\", адрес: " + address); }
}
