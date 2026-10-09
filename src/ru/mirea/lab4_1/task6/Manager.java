package ru.mirea.lab4_1.task6;

public class Manager extends Employer {
    private double averageSum;      // средние доп. выплаты с продаж в месяц

    public Manager(String firstName, String lastName, double income, double averageSum) {
        // Поля родителя инициализирует конструктор родителя - не дублируем эту логику.
        super(firstName, lastName, income);
        this.averageSum = averageSum;
    }

    public double getAverageSum() { return averageSum; }

    // super.getIncome() - годовая зарплата, посчитанная так же, как у обычного сотрудника.
    // Мы не копируем формулу "income * 12", а переиспользуем её: если правило расчёта зарплаты
    // в Employer поменяется, менеджер автоматически получит то же правило плюс свои продажи.
    @Override
    public double getIncome() { return super.getIncome() + averageSum * 12; }
}
