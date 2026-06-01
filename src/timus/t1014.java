package timus;

import java.io.BufferedInputStream;
import java.io.IOException;

public class t1014 {
    public static void main(String[] args) throws IOException {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();

        if (n == 0) {
            System.out.println(10);
            return;
        }
        if (n == 1) {
            System.out.println(1);
            return;
        }

        StringBuilder digits = new StringBuilder();

        for (int digit = 9; digit >= 2; digit--) {
            while (n % digit == 0) {
                digits.append(digit);
                n /= digit;
            }
        }

        if (n != 1) {
            System.out.println(-1);
            return;
        }

        System.out.println(digits.reverse());
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
