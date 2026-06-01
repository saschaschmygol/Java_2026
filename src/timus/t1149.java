package timus;

import java.util.Scanner;

public class t1149 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String result = buildA(1) + "+" + n;

        for (int i = 2; i <= n; i++) {
            result = "(" + result + ")" + buildA(i) + "+" + (n - i + 1);
        }

        System.out.println(result);
    }

    private static String buildA(int n) {
        StringBuilder expression = new StringBuilder("sin(1");

        for (int i = 2; i <= n; i++) {
            expression.append(i % 2 == 0 ? "-sin(" : "+sin(").append(i);
        }

        for (int i = 0; i < n; i++) {
            expression.append(")");
        }

        return expression.toString();
    }
}
