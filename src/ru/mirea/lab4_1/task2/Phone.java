package ru.mirea.lab4_1.task2;

public class Phone {
    private String number;
    private String model;
    private double weight;

    // 9) Конструктор без параметров. Значения-заглушки лучше, чем null:
    // иначе любой вызов number.length() где-то дальше упадёт с NullPointerException.
    public Phone() {
        this("не указан", "неизвестная модель");
    }

    // 8) Конструктор с двумя параметрами. Вес по умолчанию 0 - "не известен".
    public Phone(String number, String model) {
        this.number = number;
        this.model = model;
    }

    // 7) + 10) Конструктор с тремя параметрами вызывает конструктор с двумя через this(...).
    // Так присваивание number и model написано ровно в одном месте. this(...) обязан быть ПЕРВОЙ строкой.
    public Phone(String number, String model, double weight) {
        this(number, model);
        this.weight = weight;
    }

    // 5) getNumber
    public String getNumber() { return number; }
    public String getModel() { return model; }
    public double getWeight() { return weight; }

    // 3)-4) receiveCall с одним параметром
    public void receiveCall(String name) {
        System.out.println("Звонит " + name);
    }

    // 11) Перегрузка (overloading): то же имя, но другой список параметров.
    // Компилятор выбирает нужную версию по количеству и типам аргументов ещё на этапе компиляции.
    public void receiveCall(String name, String callerNumber) {
        System.out.println("Звонит " + name + " (" + callerNumber + ") на номер " + number);
    }

    // 13)-14) Аргументы переменной длины (varargs). Внутри метода numbers - обычный массив String[],
    // а вызывать можно и с одним номером, и с пятью, и вообще без номеров.
    public void sendMessage(String... numbers) {
        if (numbers.length == 0) {
            System.out.println("Не указано ни одного получателя.");
            return;
        }
        System.out.println("Сообщение с " + number + " отправлено на номера:");
        for (String n : numbers) System.out.println("  " + n);
    }

    @Override
    public String toString() { return "Phone{number='" + number + "', model='" + model + "', weight=" + weight + "}"; }
}
