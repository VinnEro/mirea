package ru.mirea.lab3.format.task1;
import java.util.Scanner;

public class ConverterTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Доступные валюты: " + String.join(", ", CurrencyConverter.getCodes()));

        System.out.print("Введите сумму: ");
        // Не nextDouble(): он зависит от локали системы, и на русской локали "12.5" вызовет исключение
        // (ожидается "12,5"). Читаем строку и сами приводим запятую к точке - так подходят оба варианта.
        double amount = Double.parseDouble(sc.next().replace(',', '.'));
        System.out.print("Из какой валюты: ");
        String from = sc.next();
        System.out.print("В какую валюту: ");
        String to = sc.next();

        if (!CurrencyConverter.isSupported(from) || !CurrencyConverter.isSupported(to)) {
            System.out.println("Такая валюта не поддерживается.");
            return;
        }

        double result = CurrencyConverter.convert(amount, from, to);
        System.out.println(CurrencyConverter.format(amount, from) + " = " + CurrencyConverter.format(result, to));

        // Сводная таблица: та же сумма во всех валютах. %-5s и %15s выравнивают столбцы.
        System.out.println("\nСумма во всех валютах:");
        for (String code : CurrencyConverter.getCodes()) {
            System.out.printf("%-5s%15s%n", code, CurrencyConverter.format(CurrencyConverter.convert(amount, from, code), code));
        }
    }
}
