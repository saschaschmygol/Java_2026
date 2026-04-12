package lr4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task1AveragePositive {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите количество элементов массива: ");
            int n = scanner.nextInt();

            if (n <= 0) {
                throw new NegativeArraySizeException("Размер массива должен быть больше 0.");
            }

            int[] arr = new int[n];

            System.out.println("Введите элементы массива типа int:");
            for (int i = 0; i < n; i++) {
                System.out.print("arr[" + i + "] = ");
                arr[i] = scanner.nextInt();
            }

            int sum = 0;
            int count = 0;

            for (int value : arr) {
                if (value > 0) {
                    sum += value;
                    count++;
                }
            }

            if (count == 0) {
                throw new ArithmeticException("Положительные элементы отсутствуют.");
            }

            double average = (double) sum / count;
            System.out.println("Среднее значение положительных элементов = " + average);

        } catch (InputMismatchException e) {
            System.out.println("Ошибка: введено не число или число не соответствует типу int.");
        } catch (NegativeArraySizeException | ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            System.out.println("Программа Task1AveragePositive завершена.");
        }
    }
}