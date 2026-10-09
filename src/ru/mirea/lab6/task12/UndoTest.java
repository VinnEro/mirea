package ru.mirea.lab6.task12;

public class UndoTest {
    public static void main(String[] args) {
        UndoableStringBuilder sb = new UndoableStringBuilder("Hello");

        sb.append(", World").append('!').append(2026);
        System.out.println("append x3:      " + sb);
        sb.insert(5, " dear");
        System.out.println("insert:         " + sb);
        sb.replace(0, 5, "Goodbye");
        System.out.println("replace:        " + sb);
        sb.deleteCharAt(sb.length() - 1);
        System.out.println("deleteCharAt:   " + sb);
        sb.reverse();
        System.out.println("reverse:        " + sb);
        sb.setCharAt(0, '#');
        System.out.println("setCharAt:      " + sb);

        System.out.println("\nОперации в истории: " + sb.getHistorySize());
        // Отменяем всё по одному шагу и смотрим, как строка "откатывается" назад.
        while (sb.undo()) {
            System.out.println("undo -> " + sb);
        }
        System.out.println("Отменять больше нечего, строка вернулась к исходной: \"" + sb + "\"");
    }
}
