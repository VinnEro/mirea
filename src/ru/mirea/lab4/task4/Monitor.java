package ru.mirea.lab4.task4;

public class Monitor {
    private double diagonal;
    private int widthPx, heightPx;

    public Monitor(double diagonal, int widthPx, int heightPx) { this.diagonal = diagonal; this.widthPx = widthPx; this.heightPx = heightPx; }
    public double getDiagonal() { return diagonal; }
    public String getResolution() { return widthPx + "x" + heightPx; }

    @Override public String toString() { return String.format("%.1f\" %s", diagonal, getResolution()); }
}
