package ru.mirea.lab4.task3;

public class User {
    private String login;
    private String password;

    public User(String login, String password) { this.login = login; this.password = password; }
    public String getLogin() { return login; }

    // Пароль наружу не отдаём (нет getPassword) - объект сам проверяет, подходит ли введённый.
    // Строки сравниваем через equals: оператор == сравнил бы ссылки, а не текст.
    public boolean checkPassword(String password) { return this.password.equals(password); }
}
