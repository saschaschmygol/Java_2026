package timus;

import java.util.Scanner;

public class t2001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a1 = sc.nextInt();
        int b1 = sc.nextInt();
        sc.nextInt();
        int b2 = sc.nextInt();
        int a3 = sc.nextInt();
        sc.nextInt();

        System.out.println((a1 - a3) + " " + (b1 - b2));
    }
}
