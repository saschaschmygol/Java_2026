package timus;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public class t_1001 {
    public static void main(String[] args) throws IOException {
        FastScanner scanner = new FastScanner();
        ArrayList<Double> numbers = new ArrayList<>();

        String token;
        while ((token = scanner.next()) != null) {
            if (token.equalsIgnoreCase("end")) {
                break;
            }

            numbers.add(Double.parseDouble(token));
        }

        StringBuilder answer = new StringBuilder();

        for (int i = numbers.size() - 1; i >= 0; i--) {
            answer.append(String.format(Locale.US, "%.4f%n", Math.sqrt(numbers.get(i))));
        }

        System.out.print(answer);
    }

    private static class FastScanner {
        private final BufferedInputStream input = new BufferedInputStream(System.in);
        private final byte[] buffer = new byte[8192];
        private int length = 0;
        private int position = 0;

        String next() throws IOException {
            StringBuilder token = new StringBuilder();
            int c;

            do {
                c = read();
                if (c == -1) {
                    return null;
                }
            } while (Character.isWhitespace(c));

            while (c != -1 && !Character.isWhitespace(c)) {
                token.append((char) c);
                c = read();
            }

            return token.toString();
        }

        private int read() throws IOException {
            if (position >= length) {
                length = input.read(buffer);
                position = 0;

                if (length <= 0) {
                    return -1;
                }
            }

            return buffer[position++];
        }
    }
}
