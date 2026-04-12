package timus;

import java.util.Scanner;

public class t2012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int f = sc.nextInt();

        int remaining = 12 - f;
        int availableMinutes = 4 * 60; // после первого часа осталось 4 часа
        int neededMinutes = remaining * 45;

        if (neededMinutes <= availableMinutes) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        sc.close();
    }
}