package ru.mirea.lab6.task13;
import java.util.ArrayList;
import java.util.List;

// Как и в task12: StringBuilder - final, поэтому оборачиваем его и делегируем вызовы.
public class ObservableStringBuilder {
    private final StringBuilder builder = new StringBuilder();
    // Список, а не массив фиксированного размера: подписчики приходят и уходят во время работы программы,
    // и заранее неизвестно, сколько их будет.
    private final List<StringBuilderListener> listeners = new ArrayList<>();

    public void subscribe(StringBuilderListener listener) {
        // Защита от двойной подписки - иначе один и тот же наблюдатель получал бы каждое событие дважды.
        if (!listeners.contains(listener)) listeners.add(listener);
    }

    public void unsubscribe(StringBuilderListener listener) { listeners.remove(listener); }

    private void notifyListeners(String operation) {
        // Проходим по копии списка: если подписчик внутри onChange решит отписаться,
        // изменение исходного списка во время обхода вызвало бы ConcurrentModificationException.
        for (StringBuilderListener listener : new ArrayList<>(listeners)) {
            listener.onChange(this, operation);
        }
    }

    public ObservableStringBuilder append(Object value) {
        builder.append(value);
        notifyListeners("append(" + value + ")");
        return this;
    }

    public ObservableStringBuilder insert(int offset, Object value) {
        builder.insert(offset, value);
        notifyListeners("insert(" + offset + ", " + value + ")");
        return this;
    }

    public ObservableStringBuilder delete(int start, int end) {
        builder.delete(start, end);
        notifyListeners("delete(" + start + ", " + end + ")");
        return this;
    }

    public ObservableStringBuilder replace(int start, int end, String str) {
        builder.replace(start, end, str);
        notifyListeners("replace(" + start + ", " + end + ", " + str + ")");
        return this;
    }

    public ObservableStringBuilder reverse() {
        builder.reverse();
        notifyListeners("reverse()");
        return this;
    }

    // Методы чтения не меняют состояние - уведомлять о них некого и незачем.
    public int length() { return builder.length(); }
    public char charAt(int index) { return builder.charAt(index); }

    @Override public String toString() { return builder.toString(); }
}
