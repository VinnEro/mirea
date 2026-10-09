package ru.mirea.lab4_1.task3;

public class PersonTest {
    public static void main(String[] args) {
        Person anonymous = new Person();
        Person vlad = new Person("Иващенко Владислав", 19);

        System.out.println(anonymous);
        anonymous.move();
        anonymous.talk();

        System.out.println(vlad);
        vlad.move();
        vlad.talk();
    }
}
