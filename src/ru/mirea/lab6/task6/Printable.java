package ru.mirea.lab6.task6;

// Пакет task6 закрывает сразу пункты 6-9 задания: они описывают одну и ту же маленькую программу
// (интерфейс Printable -> классы Book и Shop -> массив Printable), поэтому разносить их по разным пакетам незачем.
public interface Printable {
    void print();
}
