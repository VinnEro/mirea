package ru.mirea.lab4_1.task4;

public class Matrix {
    private double[][] data;
    private int rows, cols;

    public Matrix(int rows, int cols) {
        // Матрица 0xN или отрицательного размера бессмысленна - лучше сразу сообщить об ошибке.
        if (rows <= 0 || cols <= 0) throw new IllegalArgumentException("Размеры матрицы должны быть положительными");
        this.rows = rows;
        this.cols = cols;
        this.data = new double[rows][cols];
    }

    // Конструктор из готового массива. Копируем данные, а не сохраняем ссылку:
    // иначе изменение исходного массива снаружи "тихо" поменяло бы и нашу матрицу.
    public Matrix(double[][] values) {
        this(values.length, values[0].length);
        for (int i = 0; i < rows; i++) {
            if (values[i].length != cols) throw new IllegalArgumentException("Строки матрицы разной длины");
            for (int j = 0; j < cols; j++) data[i][j] = values[i][j];
        }
    }

    public int getRows() { return rows; }
    public int getCols() { return cols; }
    public double get(int i, int j) { return data[i][j]; }
    public void set(int i, int j, double value) { data[i][j] = value; }

    // Все операции возвращают НОВУЮ матрицу и не меняют текущую.
    // Так a.add(b) не портит a, и выражения вроде a.add(b).multiply(2) читаются как обычная математика.
    public Matrix add(Matrix other) {
        if (rows != other.rows || cols != other.cols) {
            throw new IllegalArgumentException("Складывать можно только матрицы одинакового размера");
        }
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result.data[i][j] = data[i][j] + other.data[i][j];
        return result;
    }

    public Matrix multiply(double number) {
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result.data[i][j] = data[i][j] * number;
        return result;
    }

    // Умножение матриц (по желанию). Условие: столбцов у первой = строк у второй.
    // Результат имеет размер rows x other.cols, а каждый элемент - это сумма произведений
    // i-й строки первой матрицы на j-й столбец второй.
    public Matrix multiply(Matrix other) {
        if (cols != other.rows) {
            throw new IllegalArgumentException("Число столбцов первой матрицы должно совпадать с числом строк второй");
        }
        Matrix result = new Matrix(rows, other.cols);
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < other.cols; j++) {
                double sum = 0;
                for (int k = 0; k < cols; k++) sum += data[i][k] * other.data[k][j];
                result.data[i][j] = sum;
            }
        return result;
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) System.out.printf("%8.2f", data[i][j]);
            System.out.println();
        }
    }
}
