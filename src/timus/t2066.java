package timus;
import java.util.Scanner;

public class t2066 {
    static int calc(int x, int y, int z, char op1, char op2) {
        // учитываем приоритет операций
        if (op2 == '*') {
            int temp = y * z;
            return apply(x, temp, op1);
        } else if (op1 == '*') {
            int temp = x * y;
            return apply(temp, z, op2);
        } else {
            int temp = apply(x, y, op1);
            return apply(temp, z, op2);
        }
    }

    static int apply(int a, int b, char op) {
        if (op == '+') return a + b;
        if (op == '-') return a - b;
        return a * b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int[] nums = {a, b, c};
        int min = Integer.MAX_VALUE;

        char[] ops = {'+', '-', '*'};

        // все перестановки 3 чисел
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == i) continue;
                for (int k = 0; k < 3; k++) {
                    if (k == i || k == j) continue;

                    int x = nums[i];
                    int y = nums[j];
                    int z = nums[k];

                    // все комбинации операций
                    for (char op1 : ops) {
                        for (char op2 : ops) {
                            int value = calc(x, y, z, op1, op2);
                            min = Math.min(min, value);
                        }
                    }
                }
            }
        }

        System.out.println(min);
    }

}
