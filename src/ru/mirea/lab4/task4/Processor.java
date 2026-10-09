package ru.mirea.lab4.task4;

public class Processor {
    private String model;
    private int cores;
    private double frequencyGHz;

    public Processor(String model, int cores, double frequencyGHz) { this.model = model; this.cores = cores; this.frequencyGHz = frequencyGHz; }
    public String getModel() { return model; }
    public int getCores() { return cores; }
    public double getFrequencyGHz() { return frequencyGHz; }

    @Override public String toString() { return String.format("%s (ядер: %d, %.2f ГГц)", model, cores, frequencyGHz); }
}
