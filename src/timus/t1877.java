package timus;

import java.util.Scanner;

public class t1877 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        int a = Integer.parseInt(s1);
        int b = Integer.parseInt(s2);

        if (a % 2 == 0 || b % 2 == 1) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
