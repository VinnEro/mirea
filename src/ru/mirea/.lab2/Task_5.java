package ru.mirea.lab2;

public class Task_5 {
    public static void main(String[] args) {
        DogKennel kennel = new DogKennel(5);
        kennel.addDog(new Dog("Rex", 3));
        kennel.addDog(new Dog("Bobik", 5));
        kennel.printDogs();
    }
}

class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) { this.name = name; this.age = age; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public int toHumanAge() { return age * 7; }

    @Override
    public String toString() {
        return "Dog{name='" + name + "', age=" + age + ", humanAge=" + toHumanAge() + "}";
    }
}

class DogKennel {
    private Dog[] dogs;
    private int count = 0;

    public DogKennel(int capacity) { dogs = new Dog[capacity]; }

    public void addDog(Dog dog) {
        if (count < dogs.length) dogs[count++] = dog;
    }

    public void printDogs() {
        for (int i = 0; i < count; i++) System.out.println(dogs[i]);
    }
}