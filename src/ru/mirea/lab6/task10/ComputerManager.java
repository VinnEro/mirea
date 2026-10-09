package ru.mirea.lab6.task10;
import ru.mirea.lab4.task4.Computer;

// Компьютер, процессор, память, монитор и марки (enum) уже написаны в lab4.task4 - ровно по такому же условию.
// Поэтому здесь импортируем их, а не копируем: два одинаковых класса Computer в проекте пришлось бы поддерживать дважды.
//
// Интерфейс отделяет "что умеет магазин" от "как он это хранит". Сейчас Shop хранит компьютеры в массиве,
// но если завтра понадобится хранить их в базе данных, достаточно написать новый класс, реализующий этот интерфейс.
public interface ComputerManager {
    boolean addComputer(Computer computer);
    boolean removeComputer(String name);
    Computer findComputer(String name);
    void printAll();
}
