package ru.mirea.lab4_1.task7;

// Учащийся - общий предок школьника и студента: у обоих есть имя и возраст,
// а различия (класс у школьника, вуз и курс у студента) уходят в подклассы.
public class Learner {
    protected String name;
    protected int age;

    public Learner(String name, int age) { this.name = name; this.age = age; }
    public String getName() { return name; }
    public int getAge() { return age; }

    public void study() { System.out.println(name + " учится"); }

    @Override public String toString() { return name + ", " + age + " лет"; }
}
