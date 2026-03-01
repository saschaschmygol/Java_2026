package lr1;

import java.util.Scanner;
public class Example15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        double a = sc.nextDouble();

        System.out.print("Введите второе число: ");
        double b = sc.nextDouble();

        System.out.println("Сумма: " + (a + b));
        System.out.println("Разность (первое - второе): " + (a - b));
    }
}
