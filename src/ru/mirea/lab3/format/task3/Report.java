package ru.mirea.lab3.format.task3;

public class Report {
    // Метод статический: отчёт не хранит никакого своего состояния,
    // ему нужен только массив сотрудников - создавать объект Report ради одного вызова незачем.
    public static void generateReport(Employee[] employees) {
        // Ширину колонки с ФИО считаем по самому длинному имени, а не "на глаз" константой:
        // иначе длинная фамилия сдвинет всю таблицу.
        int nameWidth = "Сотрудник".length();
        for (Employee e : employees) nameWidth = Math.max(nameWidth, e.getFullname().length());

        // Формат собираем один раз: %-Ns - ФИО прижато влево, %15s - зарплата вправо.
        String rowFormat = "%3s | %-" + nameWidth + "s | %15s%n";
        String line = "-".repeat(3 + 3 + nameWidth + 3 + 15);

        System.out.println("Отчёт о заработной плате сотрудников");
        System.out.println(line);
        System.out.printf(rowFormat, "№", "Сотрудник", "Зарплата");
        System.out.println(line);

        double total = 0;
        for (int i = 0; i < employees.length; i++) {
            // %,.2f: разделитель тысяч + ровно 2 знака после запятой. Сначала форматируем число в строку,
            // а потом уже выравниваем строку по правому краю через %15s.
            System.out.printf(rowFormat, i + 1, employees[i].getFullname(), String.format("%,.2f", employees[i].getSalary()));
            total += employees[i].getSalary();
        }

        System.out.println(line);
        System.out.printf(rowFormat, "", "Итого", String.format("%,.2f", total));
        // "Что-нибудь своё" - средняя зарплата. Защищаемся от деления на ноль для пустого массива.
        System.out.printf(rowFormat, "", "Средняя", String.format("%,.2f", employees.length == 0 ? 0 : total / employees.length));
    }
}
