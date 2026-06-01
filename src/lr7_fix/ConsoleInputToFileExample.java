package lr7_fix;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ConsoleInputToFileExample {
    public static void main(String[] args) {

        String outputFileName = "src/lr7_fix/output.txt";

        System.out.println("Введите данные для записи в файл.");
        System.out.println("Для завершения введите слово exit");

        try (BufferedReader consoleReader =
                     new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
             PrintWriter writer =
                     new PrintWriter(new OutputStreamWriter(
                             new FileOutputStream(outputFileName),
                             StandardCharsets.UTF_8))) {

            String line;

            while (true) {
                line = consoleReader.readLine();

                if (line.equalsIgnoreCase("exit")) {
                    break;
                }

                writer.println(line);
            }

            System.out.println("Данные записаны в файл: " + outputFileName);

        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
}