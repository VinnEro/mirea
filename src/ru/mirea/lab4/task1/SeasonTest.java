package ru.mirea.lab4.task1;

public class SeasonTest {
    public static void main(String[] args) {
        // 1) Любимое время года и вся информация о нём.
        Season favourite = Season.AUTUMN;
        System.out.println("Любимое время года: " + favourite.getTitle()
                + " (константа " + favourite.name() + ", порядковый номер " + favourite.ordinal() + ")");
        System.out.println("Средняя температура: " + favourite.getAverageTemperature() + "°C");
        System.out.println("Описание: " + favourite.getDescription());
        System.out.println();

        // 2) Метод со switch.
        printLove(favourite);
        printLove(Season.SUMMER);
        System.out.println();

        // 6) values() генерируется компилятором для любого enum и возвращает константы в порядке объявления.
        // printf с %-6s и %4d даёт ровную табличку.
        System.out.println("Все времена года:");
        for (Season season : Season.values()) {
            System.out.printf("%-6s %4d°C  %s%n", season.getTitle(), season.getAverageTemperature(), season.getDescription());
        }
    }

    // switch по enum: в case пишется просто WINTER, без "Season." - компилятор и так знает тип.
    // default тут не нужен: все четыре значения перечислены. Если в enum добавят пятое значение,
    // IDE подсветит, что его забыли обработать.
    public static void printLove(Season season) {
        switch (season) {
            case WINTER:
                System.out.println("Я люблю зиму");
                break;
            case SPRING:
                System.out.println("Я люблю весну");
                break;
            case SUMMER:
                System.out.println("Я люблю лето");
                break;
            case AUTUMN:
                System.out.println("Я люблю осень");
                break;
        }
    }
}
