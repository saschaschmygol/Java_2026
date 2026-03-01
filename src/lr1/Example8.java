package lr1;

import java.util.Scanner;
public class Example8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите день недели: ");
        String dayOfWeek = sc.nextLine();

        System.out.print("Введите месяц: ");
        String month = sc.nextLine();

        System.out.print("Введите число (дату): ");
        int dayOfMonth = sc.nextInt();

        System.out.println("Сегодня: " + dayOfWeek + ", " + dayOfMonth + " " + month);
    }
}
