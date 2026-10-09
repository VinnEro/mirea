    package ru.mirea.lab2.task4;

public interface ComputerManager {
    void addComputer(Computer c);
    void removeComputer(String name);
    Computer findComputer(String name);
}