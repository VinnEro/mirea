package ru.mirea.lab4.task3;

public class Cart {
    private Product[] items;
    private int count = 0;

    public Cart(int capacity) { items = new Product[capacity]; }

    // Возвращаем boolean, чтобы вызывающий код мог сказать пользователю "корзина переполнена",
    // а не молча проглотить товар, как это делал addComputer в lab2.
    public boolean add(Product product) {
        if (count >= items.length) return false;
        items[count++] = product;
        return true;
    }

    public boolean isEmpty() { return count == 0; }

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < count; i++) total += items[i].getPrice();
        return total;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Корзина пуста.");
            return;
        }
        for (int i = 0; i < count; i++) System.out.println("  " + items[i]);
        System.out.printf("  Итого: %.2f руб.%n", getTotal());
    }

    // Обнуляем ссылки, а не только count: так старые объекты Product смогут удалиться сборщиком мусора.
    public void clear() {
        for (int i = 0; i < count; i++) items[i] = null;
        count = 0;
    }
}
