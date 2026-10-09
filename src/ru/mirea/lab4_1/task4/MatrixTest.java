package ru.mirea.lab4_1.task4;

public class MatrixTest {
    public static void main(String[] args) {
        Matrix a = new Matrix(new double[][]{{1, 2, 3}, {4, 5, 6}});
        Matrix b = new Matrix(new double[][]{{6, 5, 4}, {3, 2, 1}});
        Matrix c = new Matrix(new double[][]{{1, 0}, {0, 1}, {2, 2}});

        System.out.println("A:"); a.print();
        System.out.println("B:"); b.print();
        System.out.println("A + B:"); a.add(b).print();
        System.out.println("A * 2.5:"); a.multiply(2.5).print();
        System.out.println("C:"); c.print();
        System.out.println("A * C (2x3 * 3x2 = 2x2):"); a.multiply(c).print();

        // Проверяем, что неправильные размеры не "считаются как-нибудь", а дают понятную ошибку.
        try {
            a.add(c);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при A + C: " + e.getMessage());
        }
    }
}
