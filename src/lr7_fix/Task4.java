package lr7_fix;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя исходного файла: ");
        Path sourcePath = Path.of(scanner.nextLine());

        System.out.print("Введите имя файла для копирования: ");
        Path targetPath = Path.of(scanner.nextLine());

        try {
            Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Файл успешно скопирован.");
        } catch (IOException e) {
            System.out.println("Ошибка при копировании файла: " + e.getMessage());
        }
    }
}
