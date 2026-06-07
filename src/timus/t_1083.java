package timus;

import java.util.Scanner;

public class t_1083 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String factorialSigns = sc.next();
        int k = factorialSigns.length();

        long result = 1;

        for (int current = n; current > 0; current -= k) {
            result *= current;
        }

        System.out.println(result);
    }
}
