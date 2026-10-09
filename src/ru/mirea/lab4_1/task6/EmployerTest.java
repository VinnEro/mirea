package ru.mirea.lab4_1.task6;

public class EmployerTest {
    public static void main(String[] args) {
        // б) Переменная типа Employer ссылается на объект Manager - это upcast, он всегда безопасен,
        // потому что менеджер "является" сотрудником.
        Employer boss = new Manager("Иван", "Петров", 90000, 35000);
        System.out.println("Ссылка Employer на Manager: " + boss.getIncome());
        // Вызвался getIncome() из Manager (с продажами), хотя тип ссылки Employer, - это полиморфизм.

        // г) Массив типа Employer, в котором и обычные сотрудники, и менеджеры.
        Employer[] staff = {
                new Employer("Анна", "Смирнова", 70000),
                boss,
                new Employer("Олег", "Кузнецов", 65000),
                new Manager("Мария", "Иванова", 85000, 50000)
        };

        System.out.println();
        double total = 0;
        for (Employer e : staff) {
            System.out.println(e);
            total += e.getIncome();
        }
        System.out.printf("%nФонд оплаты труда за год: %,.2f%n", total);
    }
}
