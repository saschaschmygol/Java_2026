package timus;

import java.io.BufferedInputStream;
import java.io.IOException;

public class t2056 {
    public static void main(String[] args) throws IOException {
        FastScanner scanner = new FastScanner();

        int n = scanner.nextInt();
        int sum = 0;
        boolean hasThree = false;
        boolean onlyFive = true;

        for (int i = 0; i < n; i++) {
            int mark = scanner.nextInt();
            sum += mark;

            if (mark == 3) {
                hasThree = true;
            }
            if (mark != 5) {
                onlyFive = false;
            }
        }

        if (hasThree) {
            System.out.println("None");
        } else if (onlyFive) {
            System.out.println("Named");
        } else if (sum * 2 >= 9 * n) {
            System.out.println("High");
        } else {
            System.out.println("Common");
        }
    }

    private static class FastScanner {
        private final BufferedInputStream input = new BufferedInputStream(System.in);
        private final byte[] buffer = new byte[1 << 16];
        private int pointer = 0;
        private int length = 0;

        private int read() throws IOException {
            if (pointer >= length) {
                length = input.read(buffer);
                pointer = 0;
            }
            return length == -1 ? -1 : buffer[pointer++];
        }

        int nextInt() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= ' ' && c != -1);

            int value = 0;
            while (c > ' ') {
                value = value * 10 + c - '0';
                c = read();
            }

            return value;
        }
    }
}
