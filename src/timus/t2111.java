package timus;

import java.io.BufferedInputStream;
import java.io.IOException;

public class t2111 {
    public static void main(String[] args) throws IOException {
        FastScanner scanner = new FastScanner();

        int n = scanner.nextInt();
        long sum = 0;

        for (int i = 0; i < n; i++) {
            sum += scanner.nextInt();
        }

        System.out.println(sum * sum);
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

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            int value = 0;
            while (c > ' ') {
                value = value * 10 + c - '0';
                c = read();
            }

            return value * sign;
        }
    }
}
