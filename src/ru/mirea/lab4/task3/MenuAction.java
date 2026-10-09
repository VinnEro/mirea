package ru.mirea.lab4.task3;

// Пункты меню тоже сделаны перечислением ("можете добавить свои операции").
// Номер пункта хранится в самой константе, поэтому меню печатается циклом по values(),
// и при добавлении нового пункта не нужно править вывод меню вручную.
public enum MenuAction {
    SHOW_CATALOGS(1, "Список каталогов"),
    SHOW_PRODUCTS(2, "Товары каталога"),
    ADD_TO_CART(3, "Добавить товар в корзину"),
    SHOW_CART(4, "Показать корзину"),
    BUY(5, "Купить товары из корзины"),
    EXIT(0, "Выход");

    private final int code;
    private final String title;

    MenuAction(int code, String title) { this.code = code; this.title = title; }

    public int getCode() { return code; }
    public String getTitle() { return title; }

    // Поиск константы по номеру, который ввёл пользователь. null - если такого пункта нет.
    public static MenuAction byCode(int code) {
        for (MenuAction action : values()) {
            if (action.code == code) return action;
        }
        return null;
    }
}
