package timus;
import java.util.Scanner;

public class t1005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] w = new int[n];

        int total = 0;
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
            total += w[i];
        }

        int minDiff = Integer.MAX_VALUE;

        // перебор всех подмножеств
        for (int mask = 0; mask < (1 << n); mask++) {
            int sum = 0;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += w[i];
                }
            }

            int other = total - sum;
            int diff = Math.abs(sum - other);

            minDiff = Math.min(minDiff, diff);
        }

        System.out.println(minDiff);
    }
}
