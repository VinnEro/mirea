package ru.mirea.lab4_1.task9;

// Магазин хранит массив Furniture[] - благодаря абстрактному родителю ему всё равно,
// стул это или шкаф. Добавится новый вид мебели (например, кровать) - магазин менять не придётся.
public class FurnitureShop {
    private String title;
    private Furniture[] items;
    private int count = 0;

    public FurnitureShop(String title, int capacity) { this.title = title; items = new Furniture[capacity]; }

    public boolean add(Furniture item) {
        if (count >= items.length) return false;
        items[count++] = item;
        return true;
    }

    // Продажа = удаление из ассортимента. Тот же приём, что в Shop из lab2:
    // на место проданного ставим последний элемент - O(1), порядок нам не важен.
    public Furniture sell(String name) {
        for (int i = 0; i < count; i++) {
            if (items[i].getName().equalsIgnoreCase(name)) {
                Furniture sold = items[i];
                items[i] = items[count - 1];
                items[--count] = null;
                return sold;
            }
        }
        return null;
    }

    public Furniture findCheapest() {
        if (count == 0) return null;
        Furniture cheapest = items[0];
        for (int i = 1; i < count; i++) if (items[i].getPrice() < cheapest.getPrice()) cheapest = items[i];
        return cheapest;
    }

    public double getTotalValue() {
        double total = 0;
        for (int i = 0; i < count; i++) total += items[i].getPrice();
        return total;
    }

    public void printAssortment() {
        System.out.println("Ассортимент магазина \"" + title + "\":");
        for (int i = 0; i < count; i++) System.out.println("  " + items[i]);
    }
}
