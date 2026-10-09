package ru.mirea.lab4_1.task7;

public class Schoolboy extends Learner {
    private int grade;      // класс, 1..11

    public Schoolboy(String name, int age, int grade) { super(name, age); this.grade = grade; }
    public int getGrade() { return grade; }

    @Override public void study() { System.out.println(name + " делает домашнее задание за " + grade + " класс"); }
    @Override public String toString() { return "Школьник: " + super.toString() + ", " + grade + " класс"; }
}
