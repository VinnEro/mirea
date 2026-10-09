package ru.mirea.lab6.task10;
import ru.mirea.lab4.task4.Brand;
import ru.mirea.lab4.task4.Computer;

// Развитие Shop из lab2.task4: теперь методы возвращают результат (получилось/нет),
// а поиск работает без учёта регистра - пользователю не нужно помнить, как именно он ввёл название.
public class Shop implements ComputerManager {
    private Computer[] inventory;
    private int count = 0;

    public Shop(int capacity) { inventory = new Computer[capacity]; }

    @Override
    public boolean addComputer(Computer computer) {
        if (count >= inventory.length) return false;
        inventory[count++] = computer;
        return true;
    }

    @Override
    public boolean removeComputer(String name) {
        for (int i = 0; i < count; i++) {
            if (inventory[i].getName().equalsIgnoreCase(name)) {
                // Последний элемент переносим на место удалённого - не нужно сдвигать весь хвост массива.
                inventory[i] = inventory[count - 1];
                inventory[--count] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public Computer findComputer(String name) {
        for (int i = 0; i < count; i++) {
            if (inventory[i].getName().equalsIgnoreCase(name)) return inventory[i];
        }
        return null;
    }

    // Дополнительный поиск - по марке. Здесь enum хорошо себя показывает: сравнение через ==, без строк.
    public void printByBrand(Brand brand) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (inventory[i].getBrand() == brand) {
                System.out.println("  " + inventory[i]);
                found = true;
            }
        }
        if (!found) System.out.println("  Компьютеров марки " + brand.getTitle() + " нет.");
    }

    @Override
    public void printAll() {
        if (count == 0) {
            System.out.println("  Магазин пуст.");
            return;
        }
        for (int i = 0; i < count; i++) System.out.println("  " + (i + 1) + ". " + inventory[i]);
    }
}
