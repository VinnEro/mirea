package ru.mirea.lab4_1.task7;

public class LearnerTest {
    public static void main(String[] args) {
        Learner[] learners = {
                new Student("Владислав", 19, "РТУ МИРЭА", 2),
                new Schoolboy("Петя", 12, 6),
                new Student("Анна", 20, "МГУ", 3),
                new Schoolboy("Маша", 16, 10),
                new Learner("Слушатель курсов", 35)     // "просто учащийся" - не школьник и не студент
        };

        // Чтобы показать студентов и школьников отдельно, нужно узнать реальный класс объекта в массиве.
        // instanceof проверяет именно это. Обычного Learner не покажет ни один из двух фильтров.
        System.out.println("=== Студенты ===");
        for (Learner l : learners) {
            if (l instanceof Student) System.out.println(l);
        }

        System.out.println("\n=== Школьники ===");
        for (Learner l : learners) {
            if (l instanceof Schoolboy) System.out.println(l);
        }

        // А вот для study() проверка типа не нужна: каждый объект сам "знает", как он учится.
        System.out.println("\n=== Все учатся ===");
        for (Learner l : learners) l.study();
    }
}
