package timus;

import java.util.*;
public class t1025 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        int[] need = new int[K];

        for (int i = 0; i < K; i++) {
            int n = sc.nextInt();
            need[i] = n / 2 + 1;
        }

        Arrays.sort(need);

        int winGroups = K / 2 + 1;
        int sum = 0;
        for (int i = 0; i < winGroups; i++) {
            sum += need[i];
        }

        System.out.println(sum);
    }
}
