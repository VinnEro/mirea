package ru.mirea.lab6.task4;

public class Ticket implements Priceable {
    private String event;
    private double basePrice;
    private boolean vip;

    public Ticket(String event, double basePrice, boolean vip) { this.event = event; this.basePrice = basePrice; this.vip = vip; }

    @Override public double getPrice() { return vip ? basePrice * 2 : basePrice; }

    // VIP-билеты не участвуют в скидках - переопределяем default-метод интерфейса.
    @Override public double getPriceWithDiscount(double percent) { return vip ? getPrice() : Priceable.super.getPriceWithDiscount(percent); }

    @Override public String toString() { return "Билет на \"" + event + "\"" + (vip ? " (VIP)" : ""); }
}
