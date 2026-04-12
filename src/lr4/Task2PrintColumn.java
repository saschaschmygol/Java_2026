package lr4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task2PrintColumn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите количество строк матрицы: ");
            int rows = scanner.nextInt();

            System.out.print("Введите количество столбцов матрицы: ");
            int cols = scanner.nextInt();

            if (rows <= 0 || cols <= 0) {
                throw new NegativeArraySizeException("Размеры матрицы должны быть больше 0.");
            }

            int[][] matrix = new int[rows][cols];

            System.out.println("Введите элементы матрицы:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print("matrix[" + i + "][" + j + "] = ");
                    matrix[i][j] = scanner.nextInt();
                }
            }

            System.out.print("Введите номер столбца для вывода (нумерация с 0): ");
            int colIndex = scanner.nextInt();

            if (colIndex < 0 || colIndex >= cols) {
                throw new ArrayIndexOutOfBoundsException("Столбца с номером " + colIndex + " не существует.");
            }

            System.out.println("Столбец с номером " + colIndex + ":");
            for (int i = 0; i < rows; i++) {
                System.out.println(matrix[i][colIndex]);
            }

        } catch (InputMismatchException e) {
            System.out.println("Ошибка: введено нецелое число.");
        } catch (NegativeArraySizeException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            System.out.println("Программа Task2PrintColumn завершена.");
            scanner.close();
        }
    }
}