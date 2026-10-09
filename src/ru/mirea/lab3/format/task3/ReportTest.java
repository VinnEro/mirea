package ru.mirea.lab3.format.task3;

public class ReportTest {
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Иващенко Владислав", 95000.0),
                new Employee("Петров В. В.", 120500.5),
                new Employee("Сидорова Анна Сергеевна", 87250.75),
                new Employee("Ким Ли", 1500000.0)
        };
        Report.generateReport(employees);
    }
}
