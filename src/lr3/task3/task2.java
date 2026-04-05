package lr3.task3;

import java.util.Scanner;

public class task2 {

    public static void toBinary(int n) {
        if (n > 1) {
            toBinary(n / 2);
        }
        System.out.print(n % 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите целое число: ");
        int number = scanner.nextInt();

        if (number == 0) {
            System.out.println("0");
        } else {
            System.out.print("Двоичное представление: ");
            toBinary(Math.abs(number));
        }

        scanner.close();
    }
}