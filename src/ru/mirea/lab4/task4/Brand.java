package ru.mirea.lab4.task4;

public enum Brand {
    LENOVO("Lenovo"),
    ASUS("ASUS"),
    HP("HP"),
    APPLE("Apple"),
    DELL("Dell");

    // Человекочитаемое имя отдельно от имени константы: константы по соглашению пишутся КАПСОМ,
    // а на экран хочется выводить "Lenovo", а не "LENOVO".
    private final String title;

    Brand(String title) { this.title = title; }

    public String getTitle() { return title; }

    // Поиск без учёта регистра - пригодится, когда марку вводит пользователь (lab6, задание 10).
    // Brand.valueOf("lenovo") упал бы с исключением, потому что valueOf чувствителен к регистру.
    public static Brand fromString(String text) {
        for (Brand brand : values()) {
            if (brand.name().equalsIgnoreCase(text) || brand.title.equalsIgnoreCase(text)) return brand;
        }
        return null;
    }
}
