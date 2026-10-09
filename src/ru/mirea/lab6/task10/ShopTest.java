package ru.mirea.lab6.task10;
import ru.mirea.lab4.task4.*;
import java.util.Scanner;

public class ShopTest {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Тип переменной - интерфейс, как и рекомендуют: main не зависит от того, как устроен конкретный магазин.
        // Для поиска по марке (которого нет в интерфейсе) отдельно держим ссылку на Shop.
        Shop shop = new Shop(10);
        ComputerManager manager = shop;

        int n = readInt("Сколько компьютеров добавить? ");
        for (int i = 0; i < n; i++) {
            System.out.println("--- Компьютер " + (i + 1) + " ---");
            if (!manager.addComputer(readComputer())) {
                System.out.println("Склад заполнен, больше добавить нельзя.");
                break;
            }
        }

        System.out.println("\nВсе компьютеры в магазине:");
        manager.printAll();

        System.out.print("\nКакой компьютер найти (название)? ");
        String name = sc.nextLine();
        Computer found = manager.findComputer(name);
        System.out.println(found != null ? "Найден: " + found : "Не найден");

        System.out.print("Марка для поиска: ");
        Brand brand = Brand.fromString(sc.nextLine().trim());
        if (brand != null) shop.printByBrand(brand);
        else System.out.println("Такой марки нет.");

        System.out.print("Какой компьютер продать (удалить)? ");
        System.out.println(manager.removeComputer(sc.nextLine()) ? "Удалён." : "Такого нет.");
        manager.printAll();
    }

    // Ввод одного компьютера собран в отдельный метод, чтобы main оставался читаемым.
    private static Computer readComputer() {
        Brand brand = null;
        while (brand == null) {
            System.out.print("Марка (");
            for (Brand b : Brand.values()) System.out.print(b.getTitle() + " ");
            System.out.print("): ");
            brand = Brand.fromString(sc.nextLine().trim());
            if (brand == null) System.out.println("Неизвестная марка, попробуйте ещё раз.");
        }
        System.out.print("Название модели: ");
        String name = sc.nextLine();
        System.out.print("Процессор (модель): ");
        String cpu = sc.nextLine();
        int cores = readInt("Количество ядер: ");
        double ghz = readDouble("Частота, ГГц: ");
        int ram = readInt("Память, ГБ: ");
        double diagonal = readDouble("Диагональ монитора, дюймы: ");
        double price = readDouble("Цена, руб.: ");

        // Тип памяти и разрешение экрана не спрашиваем, чтобы ввод не был бесконечным, - ставим типичные значения.
        return new Computer(brand, name, new Processor(cpu, cores, ghz), new Memory(ram, "DDR5"),
                new Monitor(diagonal, 1920, 1080), price);
    }

    // Читаем всю строку и парсим сами, а не через nextInt(): nextInt() оставляет в буфере перевод строки,
    // и следующий nextLine() вернул бы пустую строку - классическая ловушка Scanner.
    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Нужно целое число.");
            }
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                // replace(',', '.') - чтобы "2,5" с русской раскладки тоже принималось.
                return Double.parseDouble(sc.nextLine().trim().replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.println("Нужно число.");
            }
        }
    }
}
