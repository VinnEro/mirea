package ru.mirea.lab4.task1;

public enum Season {
    WINTER("Зима", -10),
    SPRING("Весна", 8),
    // У константы может быть собственное тело класса { ... }.
    // Фактически SUMMER становится анонимным подклассом Season, и в нём можно переопределить метод.
    // Это как раз то, что просит задание: у всех "Холодное время года", а у лета - своё описание,
    // и при этом никаких if/switch внутри getDescription() не нужно.
    SUMMER("Лето", 22) {
        @Override
        public String getDescription() { return "Теплое время года"; }
    },
    AUTUMN("Осень", 6);     // точка с запятой обязательна, потому что дальше идут поля и методы

    // final: значения констант перечисления не должны меняться во время работы программы,
    // иначе "константа" перестанет быть константой.
    private final String title;
    private final int averageTemperature;

    // Конструктор enum всегда private (даже если не написать) - создавать новые времена года снаружи нельзя,
    // их ровно четыре и они перечислены выше.
    Season(String title, int averageTemperature) {
        this.title = title;
        this.averageTemperature = averageTemperature;
    }

    public String getTitle() { return title; }
    public int getAverageTemperature() { return averageTemperature; }

    public String getDescription() { return "Холодное время года"; }
}
