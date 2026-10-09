package ru.mirea.lab4_1.task2;

public class PhoneTest {
    public static void main(String[] args) {
        // 1) Три экземпляра - заодно на них видно все три конструктора.
        Phone[] phones = {
                new Phone("+7 900 111-22-33", "Samsung Galaxy S24", 167),
                new Phone("+7 900 444-55-66", "iPhone 15"),
                new Phone()
        };

        // 2) Значения переменных и 6) вызов методов для каждого объекта.
        for (Phone phone : phones) {
            System.out.println(phone);
            System.out.println("Номер: " + phone.getNumber() + ", модель: " + phone.getModel() + ", вес: " + phone.getWeight());
            phone.receiveCall("Владислав");
            System.out.println();
        }

        // 12) Перегруженный receiveCall с двумя параметрами.
        phones[0].receiveCall("Мама", "+7 900 777-88-99");

        // 13) sendMessage с разным количеством аргументов.
        phones[1].sendMessage("+7 900 111-22-33", "+7 900 999-00-11", "+7 901 000-00-00");
        phones[2].sendMessage();
    }
}
