package ru.mirea.lab3.format.task2;
import ru.mirea.lab3.format.task1.CurrencyConverter;
import java.util.Scanner;

// Мини-магазин переиспользует конвертер из задания 1 через import, а не копирует курсы к себе.
// Если курс поменяется, его придётся поправить только в одном месте.
public class OnlineShop {
    public static void main(String[] args) {
        Product[] catalog = {
                new Product("Ноутбук", 85990.0),
                new Product("Наушники", 4590.5),
                new Product("Клавиатура", 3200.0),
                new Product("Монитор", 21999.99)
        };

        Scanner sc = new Scanner(System.in);
        System.out.println("Каталог товаров:");
        for (int i = 0; i < catalog.length; i++) {
            // %2d. - номер, %-12s - название влево, %15s - цена вправо: получаются ровные колонки.
            System.out.printf("%2d. %-12s %15s%n", i + 1, catalog[i].getName(), CurrencyConverter.format(catalog[i].getPriceRub(), "RUB"));
        }

        System.out.print("Номер товара: ");
        int choice = sc.nextInt();
        if (choice < 1 || choice > catalog.length) {
            System.out.println("Нет такого товара.");
            return;
        }
        System.out.print("Количество: ");
        int quantity = sc.nextInt();
        if (quantity <= 0) {
            System.out.println("Количество должно быть положительным.");
            return;
        }

        System.out.print("Валюта оплаты (" + String.join(", ", CurrencyConverter.getCodes()) + "): ");
        String currency = sc.next().toUpperCase();
        if (!CurrencyConverter.isSupported(currency)) {
            System.out.println("Оплата в этой валюте не принимается.");
            return;
        }

        Product product = catalog[choice - 1];
        double totalRub = product.getPriceRub() * quantity;
        double total = CurrencyConverter.convert(totalRub, "RUB", currency);

        System.out.println("\n=========== ЧЕК ===========");
        System.out.printf("%-12s x%-3d %12s%n", product.getName(), quantity, CurrencyConverter.format(totalRub, "RUB"));
        System.out.printf("К оплате (%s): %15s%n", currency, CurrencyConverter.format(total, currency));
        System.out.println("===========================");
    }
}
