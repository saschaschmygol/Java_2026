package lr1;

import java.util.Scanner;
public class Example14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите число: ");
        int n = sc.nextInt();

        int a = n - 1;
        int b = n;
        int c = n + 1;

        int sum = a + b + c;
        int fourth = sum * sum;

        System.out.println(a + " " + b + " " + c + " " + fourth);
    }
}
