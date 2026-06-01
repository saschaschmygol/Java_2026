package lr7_fix;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя файла: ");
        Path filePath = Path.of(scanner.nextLine());

        try {
            long size = Files.size(filePath);
            System.out.println("Размер файла в байтах: " + size);
        } catch (IOException e) {
            System.out.println("Ошибка при получении размера файла: " + e.getMessage());
        }
    }
}
