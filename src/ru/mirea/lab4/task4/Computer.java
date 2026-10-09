package ru.mirea.lab4.task4;

// Компьютер СОСТОИТ из процессора, памяти и монитора - это композиция ("has-a"), а не наследование.
// Компьютер не является процессором, поэтому extends тут был бы ошибкой проектирования.
// Плюс такого подхода: процессор или монитор можно описать и протестировать отдельно,
// а Computer просто собирает их вместе.
public class Computer {
    private Brand brand;
    private String name;
    private Processor processor;
    private Memory memory;
    private Monitor monitor;
    private double price;

    public Computer(Brand brand, String name, Processor processor, Memory memory, Monitor monitor, double price) {
        this.brand = brand;
        this.name = name;
        this.processor = processor;
        this.memory = memory;
        this.monitor = monitor;
        this.price = price;
    }

    public Brand getBrand() { return brand; }
    public String getName() { return name; }
    public Processor getProcessor() { return processor; }
    public Memory getMemory() { return memory; }
    public Monitor getMonitor() { return monitor; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    // Апгрейд памяти - пример поведения, которое меняет только одну "деталь", не трогая остальные.
    public void upgradeMemory(Memory newMemory) { this.memory = newMemory; }

    @Override
    public String toString() {
        return String.format("%s %s | CPU: %s | RAM: %s | Монитор: %s | %.2f руб.",
                brand.getTitle(), name, processor, memory, monitor, price);
    }
}
