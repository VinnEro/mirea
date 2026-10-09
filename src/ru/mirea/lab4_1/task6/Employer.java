package ru.mirea.lab4_1.task6;

public class Employer {
    protected String firstName, lastName;
    protected double income;        // месячная зарплата

    public Employer(String firstName, String lastName, double income) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.income = income;
    }

    // Условие в методичке сформулировано неразборчиво ("если средняя количество отработанных дней...").
    // Трактуем его так: income - это зарплата за месяц, а getIncome() возвращает годовой доход, то есть * 12.
    public double getIncome() { return income * 12; }

    public String getFullName() { return firstName + " " + lastName; }

    @Override public String toString() { return String.format("%-10s %-20s годовой доход: %,12.2f", getClass().getSimpleName(), getFullName(), getIncome()); }
}
