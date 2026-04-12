package lr4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task3ByteArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите количество элементов массива: ");
            int n = scanner.nextInt();

            if (n <= 0) {
                throw new NegativeArraySizeException("Размер массива должен быть больше 0.");
            }

            byte[] arr = new byte[n];

            System.out.println("Введите элементы массива типа byte:");
            for (int i = 0; i < n; i++) {
                System.out.print("arr[" + i + "] = ");
                arr[i] = scanner.nextByte();
            }

            int tempSum = 0;
            for (byte value : arr) {
                tempSum += value;

                if (tempSum < Byte.MIN_VALUE || tempSum > Byte.MAX_VALUE) {
                    throw new ArithmeticException(
                            "Сумма выходит за границы диапазона byte: от "
                                    + Byte.MIN_VALUE + " до " + Byte.MAX_VALUE
                    );
                }
            }

            byte sum = (byte) tempSum;
            System.out.println("Сумма элементов массива = " + sum);

        } catch (InputMismatchException e) {
            System.out.println("Ошибка: введено не число типа byte или значение вне диапазона byte.");
        } catch (NegativeArraySizeException | ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            System.out.println("Программа Task3ByteArraySum завершена.");
            scanner.close();
        }
    }
}
