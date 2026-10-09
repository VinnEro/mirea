package ru.mirea.lab6.task13;

// Шаблон "Наблюдатель": объекты-подписчики реализуют этот интерфейс,
// а ObservableStringBuilder вызывает onChange у каждого из них после любого изменения.
// Издатель знает о подписчиках только то, что у них есть метод onChange - никакой зависимости от их классов.
public interface StringBuilderListener {
    void onChange(ObservableStringBuilder source, String operation);
}
