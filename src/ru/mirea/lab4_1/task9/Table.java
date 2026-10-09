package ru.mirea.lab4_1.task9;

public class Table extends Furniture {
    private int seats;

    public Table(String name, String material, double price, int seats) {
        super(name, material, price);
        this.seats = seats;
    }

    public int getSeats() { return seats; }

    @Override public String getPurpose() { return "обедать или работать, мест: " + seats; }
}
