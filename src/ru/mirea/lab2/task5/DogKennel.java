package ru.mirea.lab2.task5;

public class DogKennel {
    private Dog[] dogs;
    private int count = 0;

    public DogKennel(int capacity) { dogs = new Dog[capacity]; }
    public void addDog(Dog dog) { if (count < dogs.length) dogs[count++] = dog; }
    public void printDogs() { for (int i = 0; i < count; i++) System.out.println(dogs[i]); }

    public static void main(String[] args) {
        DogKennel kennel = new DogKennel(5);
        kennel.addDog(new Dog("Rex", 3));
        kennel.addDog(new Dog("Bobik", 5));
        kennel.printDogs();
    }
}