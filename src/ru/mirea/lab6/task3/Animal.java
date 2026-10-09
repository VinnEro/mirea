package ru.mirea.lab6.task3;

public class Animal implements Nameable {
    private String species;
    private String nickname;

    public Animal(String species, String nickname) { this.species = species; this.nickname = nickname; }

    @Override public String getName() { return species + " по кличке " + nickname; }
}
