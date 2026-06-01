package lr7_fix;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя файла: ");
        Path filePath = Path.of(scanner.nextLine());

        System.out.print("Введите текст для записи в файл: ");
        String text = scanner.nextLine();

        try {
            Files.writeString(filePath, text);
            System.out.println("Количество записанных символов: " + text.length());
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
}
