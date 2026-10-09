package ru.mirea.lab7.task5;

public class ProcessStrings implements StringProcessable {

    @Override
    public int countChars(String s) { return s.length(); }

    @Override
    public int countChar(String s, char c) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) count++;
        }
        return count;
    }

    // Позиции 1, 3, 5 в задании - это "человеческая" нумерация с единицы.
    // В Java индексы идут с нуля, поэтому позиции 1, 3, 5 - это индексы 0, 2, 4.
    // Шагаем по 2, а не проверяем i % 2 на каждом символе - так в два раза меньше итераций.
    // StringBuilder вместо "result += ch": строки неизменяемы, и += в цикле каждый раз создавал бы новую строку.
    @Override
    public String oddPositions(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i += 2) sb.append(s.charAt(i));
        return sb.toString();
    }

    // Переворачиваем вручную двумя указателями, а не через new StringBuilder(s).reverse():
    // иначе интерфейс был бы просто обёрткой над готовым методом.
    @Override
    public String invert(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }
        return new String(chars);
    }
}
