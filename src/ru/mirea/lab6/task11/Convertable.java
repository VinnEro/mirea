package ru.mirea.lab6.task11;

// Один метод convert - а сколько угодно реализаций: в Кельвины, в Фаренгейты, потом можно добавить Ранкины.
// Код, который пользуется конвертером, не меняется: он просто получает другой объект Convertable.
public interface Convertable {
    double convert(double celsius);
    String getUnit();
}
