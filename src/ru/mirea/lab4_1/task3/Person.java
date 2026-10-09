package ru.mirea.lab4_1.task3;

public class Person {
    private String fullName;
    private int age;

    // Конструктор по умолчанию задаёт осмысленные значения, а не оставляет fullName = null:
    // иначе move() и talk() напечатали бы "null говорит".
    public Person() {
        this("Аноним", 0);
    }

    public Person(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    public String getFullName() { return fullName; }
    public int getAge() { return age; }

    public void move() { System.out.println(fullName + " идёт"); }
    public void talk() { System.out.println(fullName + " говорит"); }

    @Override public String toString() { return "Person{fullName='" + fullName + "', age=" + age + "}"; }
}
