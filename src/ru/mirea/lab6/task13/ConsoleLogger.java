package ru.mirea.lab6.task13;

// Первый подписчик - просто пишет в консоль каждое изменение.
public class ConsoleLogger implements StringBuilderListener {
    @Override
    public void onChange(ObservableStringBuilder source, String operation) {
        System.out.println("[LOG] " + operation + " -> \"" + source + "\"");
    }
}
