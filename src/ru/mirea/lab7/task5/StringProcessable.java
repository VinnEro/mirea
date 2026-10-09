package ru.mirea.lab7.task5;

// Интерфейс для работы со строками (пункт 5), реализация - ProcessStrings (пункт 6).
public interface StringProcessable {
    // а) подсчёт символов: всего и конкретного символа
    int countChars(String s);
    int countChar(String s, char c);

    // б) строка из символов, стоящих на нечётных позициях 1, 3, 5, ...
    String oddPositions(String s);

    // в) инвертирование (переворот) строки
    String invert(String s);
}
