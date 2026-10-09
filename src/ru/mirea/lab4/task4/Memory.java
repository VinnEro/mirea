package ru.mirea.lab4.task4;

public class Memory {
    private int sizeGb;
    private String type;    // DDR4, DDR5 ...

    public Memory(int sizeGb, String type) { this.sizeGb = sizeGb; this.type = type; }
    public int getSizeGb() { return sizeGb; }
    public String getType() { return type; }

    @Override public String toString() { return sizeGb + " ГБ " + type; }
}
