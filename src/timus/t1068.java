package timus;

import java.util.Scanner;
public class t1068 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long sum;

        if (N >= 1) {
            sum = (long) N * (N + 1) / 2;
        } else {
            sum = (long) (N + 1) * (1 - N + 1) / 2;
        }

        System.out.println(sum);
    }
}
