package ru.mirea.lab3.format.task1;

public class CurrencyConverter {
    // Курсы хранятся относительно ОДНОЙ базовой валюты (рубля).
    // Тогда для N валют нужно N курсов, а не N*N: любую пару считаем через рубль -
    // сначала переводим сумму в рубли, потом из рублей в нужную валюту.
    // Курсы условные - для учебной задачи важна логика, а не актуальность.
    private static final String[] CODES = {"RUB", "USD", "EUR", "CNY"};
    private static final String[] SYMBOLS = {"₽", "$", "€", "¥"};
    private static final double[] RATES_TO_RUB = {1.0, 92.5, 100.3, 12.8};

    // Возвращает индекс валюты или -1. Регистр не важен, чтобы "usd" от пользователя тоже работало.
    private static int indexOf(String code) {
        for (int i = 0; i < CODES.length; i++) {
            if (CODES[i].equalsIgnoreCase(code)) return i;
        }
        return -1;
    }

    public static boolean isSupported(String code) { return indexOf(code) != -1; }

    // Делаем копию, чтобы вызывающий код не мог испортить наш внутренний массив кодов.
    public static String[] getCodes() { return CODES.clone(); }

    public static double convert(double amount, String from, String to) {
        int fromIndex = indexOf(from);
        int toIndex = indexOf(to);
        // Лучше сразу "упасть" с понятным сообщением, чем молча вернуть 0 и посчитать неверную сумму.
        if (fromIndex == -1 || toIndex == -1) {
            throw new IllegalArgumentException("Неизвестная валюта: " + (fromIndex == -1 ? from : to));
        }
        double inRubles = amount * RATES_TO_RUB[fromIndex];
        return inRubles / RATES_TO_RUB[toIndex];
    }

    // Форматирование вынесено сюда же: символ валюты знает только конвертер.
    // %,.2f - два знака после запятой и разделитель тысяч (1 234,50) - деньги так читать проще.
    public static String format(double amount, String code) {
        int index = indexOf(code);
        return String.format("%,.2f %s", amount, index == -1 ? code : SYMBOLS[index]);
    }
}
