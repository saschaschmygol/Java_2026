package lr1;

import java.util.Scanner;
public class Example13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        double a = sc.nextDouble();

        System.out.print("Введите второе число: ");
        double b = sc.nextDouble();

        double sum = a + b;
        System.out.println("Сумма: " + sum);
    }
}
