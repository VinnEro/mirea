package ru.mirea.lab3.wrappers.task2;

// Таблица 3.2 из методички: какие методы есть у каких классов-оболочек.
// Таблицу проще и нагляднее хранить как двумерный массив, а не печатать 13 строк руками:
// тогда printf гарантирует ровные столбцы, а поправить отметку можно в одном месте.
public class WrapperMethodsTable {
    public static void main(String[] args) {
        String[] classes = {"Boolean", "Byte", "Character", "Double", "Float", "Integer", "Long", "Short", "isStatic"};

        // Столбцы: Boolean, Byte, Character, Double, Float, Integer, Long, Short, isStatic.
        String[][] table = {
                // xxxValue() объявлены в абстрактном классе Number. Boolean и Character НЕ наследуют Number,
                // поэтому у них этих методов нет. Методы экземпляра - не статические.
                {"byteValue",                 "", "x", "", "x", "x", "x", "x", "x", ""},
                {"doubleValue",               "", "x", "", "x", "x", "x", "x", "x", ""},
                {"floatValue",                "", "x", "", "x", "x", "x", "x", "x", ""},
                {"intValue",                  "", "x", "", "x", "x", "x", "x", "x", ""},
                {"longValue",                 "", "x", "", "x", "x", "x", "x", "x", ""},
                {"shortValue",                "", "x", "", "x", "x", "x", "x", "x", ""},
                // parseXxx есть у всех, кроме Character: символ из строки берут через charAt(), "парсить" нечего.
                {"parseXxx",                  "x", "x", "", "x", "x", "x", "x", "x", "x"},
                // Система счисления имеет смысл только для целых чисел, поэтому radix есть
                // только у Byte, Short, Integer, Long.
                {"parseXxx with radix",       "", "x", "", "", "", "x", "x", "x", "x"},
                {"valueOf with radix",        "", "x", "", "", "", "x", "x", "x", "x"},
                // toString() унаследован от Object, поэтому он есть у всех.
                {"toString",                  "x", "x", "x", "x", "x", "x", "x", "x", ""},
                // Статический toString(примитив) тоже есть у всех восьми классов.
                {"toString(primitive)",       "x", "x", "x", "x", "x", "x", "x", "x", "x"},
                // А вот toString(примитив, radix) есть ТОЛЬКО у Integer и Long - у Byte и Short его нет,
                // их перед выводом в другой системе счисления приходится расширять до int.
                {"toString(primitive,radix)", "", "", "", "", "", "x", "x", "", "x"},
        };

        System.out.printf("%-26s", "");
        for (String name : classes) System.out.printf("%-10s", name);
        System.out.println();

        for (String[] row : table) {
            System.out.printf("%-26s", row[0]);
            for (int i = 1; i < row.length; i++) System.out.printf("%-10s", row[i]);
            System.out.println();
        }

        // Пару отметок проверяем "вживую", чтобы было видно, что таблица не выдумана.
        System.out.println();
        System.out.println("Integer.toString(255, 16) = " + Integer.toString(255, 16));
        System.out.println("Byte.parseByte(\"-101\", 2) = " + Byte.parseByte("-101", 2));
        System.out.println("Short.valueOf(\"7f\", 16) = " + Short.valueOf("7f", 16));
    }
}
