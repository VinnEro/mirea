package ru.mirea.lab6.task13;

public class ObserverTest {
    public static void main(String[] args) {
        ObservableStringBuilder sb = new ObservableStringBuilder();
        ConsoleLogger logger = new ConsoleLogger();
        sb.subscribe(logger);
        sb.subscribe(new LengthLimitWatcher(15));

        // Подписчик в виде лямбды: у StringBuilderListener один абстрактный метод,
        // значит это функциональный интерфейс, и отдельный класс писать не обязательно.
        int[] changes = {0};    // массив из одного элемента - обходной путь, чтобы менять "счётчик" из лямбды
        sb.subscribe((source, operation) -> changes[0]++);

        sb.append("Java").append(' ').append("Observer");
        sb.insert(0, ">> ");
        sb.replace(0, 3, "");

        System.out.println("\nОтписываем логгер - дальше он молчит:");
        sb.unsubscribe(logger);
        sb.reverse();
        sb.append(" pattern demo");

        System.out.println("\nИтоговая строка: " + sb);
        System.out.println("Всего изменений (счётчик-лямбда): " + changes[0]);
    }
}
