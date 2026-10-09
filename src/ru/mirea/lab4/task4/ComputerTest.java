package ru.mirea.lab4.task4;

public class ComputerTest {
    public static void main(String[] args) {
        Computer[] computers = {
                new Computer(Brand.LENOVO, "ThinkPad X1", new Processor("Intel Core i7-1365U", 10, 1.8),
                        new Memory(16, "LPDDR5"), new Monitor(14.0, 1920, 1200), 145000),
                new Computer(Brand.APPLE, "MacBook Air", new Processor("Apple M3", 8, 4.05),
                        new Memory(8, "LPDDR5"), new Monitor(13.6, 2560, 1664), 119990),
                new Computer(Brand.ASUS, "ROG Strix", new Processor("AMD Ryzen 9 7945HX", 16, 2.5),
                        new Memory(32, "DDR5"), new Monitor(16.0, 2560, 1600), 199990)
        };

        for (Computer computer : computers) System.out.println(computer);

        System.out.println("\nАпгрейд памяти у " + computers[1].getName() + ":");
        computers[1].upgradeMemory(new Memory(24, "LPDDR5"));
        System.out.println(computers[1]);

        // Пример, зачем марка - это enum: можно легко отобрать компьютеры одной марки через ==.
        System.out.println("\nВсе доступные марки:");
        for (Brand brand : Brand.values()) System.out.print(brand.getTitle() + " ");
        System.out.println();
    }
}
