package ru.mirea.lab6.task13;

// Второй подписчик реагирует только на "интересное" для себя событие - превышение длины.
// Это показывает, что разные наблюдатели могут по-разному обрабатывать одно и то же уведомление.
public class LengthLimitWatcher implements StringBuilderListener {
    private final int limit;

    public LengthLimitWatcher(int limit) { this.limit = limit; }

    @Override
    public void onChange(ObservableStringBuilder source, String operation) {
        if (source.length() > limit) {
            System.out.println("[WARN] длина строки " + source.length() + " превысила лимит " + limit);
        }
    }
}
