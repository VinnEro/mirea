package ru.mirea.lab4.task2;

public enum Size {
    // Тот же приём, что и с летом в task1: переопределяем метод только у одной константы.
    XXS(32) {
        @Override
        public String getDescription() { return "Детский размер"; }
    },
    XS(34),
    S(36),
    M(38),
    L(40);

    private final int euroSize;

    Size(int euroSize) { this.euroSize = euroSize; }

    public int getEuroSize() { return euroSize; }
    public String getDescription() { return "Взрослый размер"; }
}
