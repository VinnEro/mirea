package ru.mirea.lab4_1.task9;

public class FurnitureTest {
    public static void main(String[] args) {
        FurnitureShop shop = new FurnitureShop("Уютный дом", 10);
        shop.add(new Chair("Офисный", "пластик", 7500, true));
        shop.add(new Chair("Табурет", "дерево", 1200, false));
        shop.add(new Table("Обеденный", "дуб", 24000, 6));
        shop.add(new Wardrobe("Купе", "ЛДСП", 38000, 3));
        shop.add(new Sofa("Честер", "кожа", 89000, true));

        shop.printAssortment();
        System.out.printf("Стоимость всего товара: %,.2f руб.%n", shop.getTotalValue());
        System.out.println("Самое дешёвое: " + shop.findCheapest().getName());

        Furniture sold = shop.sell("Купе");
        System.out.println("\nПродано: " + (sold != null ? sold.getName() : "ничего"));
        System.out.println("Попытка продать несуществующее: " + shop.sell("Кровать"));
        shop.printAssortment();
    }
}
