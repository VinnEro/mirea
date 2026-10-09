package ru.mirea.lab4.task3;
import java.util.Scanner;

public class OnlineShop {
    private User[] users = {
            new User("admin", "admin"),
            new User("vinnero", "qwerty")
    };
    private Product[] products = {
            new Product("Смартфон", 29990, Catalog.ELECTRONICS),
            new Product("Наушники", 4590, Catalog.ELECTRONICS),
            new Product("Чистый код", 1200, Catalog.BOOKS),
            new Product("Грокаем алгоритмы", 950, Catalog.BOOKS),
            new Product("Худи", 3500, Catalog.CLOTHES),
            new Product("Кроссовки", 7800, Catalog.CLOTHES)
    };
    private Cart cart = new Cart(20);
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Вся логика в методах экземпляра, а main только создаёт магазин и запускает его.
        // Так полям (корзина, сканер) не нужно быть static.
        new OnlineShop().run();
    }

    public void run() {
        User user = authenticate();
        if (user == null) {
            System.out.println("Слишком много неудачных попыток. До свидания!");
            return;
        }
        System.out.println("Добро пожаловать, " + user.getLogin() + "!");

        MenuAction action;
        do {
            printMenu();
            action = MenuAction.byCode(readInt("Выберите пункт: "));
            if (action == null) {
                System.out.println("Нет такого пункта меню.");
                continue;   // в do-while continue переходит к проверке условия, а null != EXIT - цикл продолжится
            }
            switch (action) {
                case SHOW_CATALOGS: showCatalogs(); break;
                case SHOW_PRODUCTS: showProducts(chooseCatalog()); break;
                case ADD_TO_CART: addToCart(); break;
                case SHOW_CART: cart.print(); break;
                case BUY: buy(); break;
                case EXIT: System.out.println("Спасибо за покупки!"); break;
            }
        } while (action != MenuAction.EXIT);
    }

    // Даём три попытки, а не бесконечный цикл: так ведут себя настоящие системы входа.
    private User authenticate() {
        for (int attempt = 1; attempt <= 3; attempt++) {
            System.out.print("Логин: ");
            String login = sc.next();
            System.out.print("Пароль: ");
            String password = sc.next();
            for (User user : users) {
                if (user.getLogin().equals(login) && user.checkPassword(password)) return user;
            }
            // Специально не говорим, что именно неверно - логин или пароль: иначе подсказываем злоумышленнику,
            // какие логины существуют.
            System.out.println("Неверный логин или пароль (попытка " + attempt + " из 3).");
        }
        return null;
    }

    private void printMenu() {
        System.out.println("\n===== МЕНЮ =====");
        for (MenuAction action : MenuAction.values()) {
            System.out.println(action.getCode() + ". " + action.getTitle());
        }
    }

    private void showCatalogs() {
        // ordinal() - порядковый номер константы с нуля; пользователю показываем с единицы.
        for (Catalog catalog : Catalog.values()) {
            System.out.println((catalog.ordinal() + 1) + ". " + catalog.getTitle());
        }
    }

    private Catalog chooseCatalog() {
        showCatalogs();
        int index = readInt("Номер каталога: ") - 1;
        if (index < 0 || index >= Catalog.values().length) {
            System.out.println("Нет такого каталога.");
            return null;
        }
        return Catalog.values()[index];
    }

    // Показывает товары каталога и возвращает их количество (пригодится, чтобы проверить выбор номера).
    private int showProducts(Catalog catalog) {
        if (catalog == null) return 0;
        System.out.println("Каталог \"" + catalog.getTitle() + "\":");
        int number = 0;
        for (Product product : products) {
            // enum сравниваем через ==: каждая константа существует в единственном экземпляре,
            // так что сравнение ссылок здесь корректно (в отличие от строк).
            if (product.getCatalog() == catalog) System.out.println("  " + (++number) + ". " + product);
        }
        return number;
    }

    private void addToCart() {
        Catalog catalog = chooseCatalog();
        int total = showProducts(catalog);
        if (total == 0) return;

        int choice = readInt("Номер товара: ");
        if (choice < 1 || choice > total) {
            System.out.println("Нет такого товара.");
            return;
        }
        // Номер в списке - это номер среди товаров ЭТОГО каталога, а не индекс в общем массиве,
        // поэтому идём по массиву ещё раз и отсчитываем choice-й подходящий товар.
        int number = 0;
        for (Product product : products) {
            if (product.getCatalog() == catalog && ++number == choice) {
                if (cart.add(product)) System.out.println("\"" + product.getName() + "\" добавлен в корзину.");
                else System.out.println("Корзина переполнена.");
                return;
            }
        }
    }

    private void buy() {
        if (cart.isEmpty()) {
            System.out.println("Корзина пуста - покупать нечего.");
            return;
        }
        cart.print();
        System.out.printf("Покупка на сумму %.2f руб. оформлена!%n", cart.getTotal());
        cart.clear();
    }

    // Безопасное чтение числа: если ввели не число, просим ещё раз, а не падаем с InputMismatchException.
    private int readInt(String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextInt()) {
            sc.next();
            System.out.print("Введите число: ");
        }
        return sc.nextInt();
    }
}
