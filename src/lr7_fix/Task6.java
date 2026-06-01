package lr7_fix;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя файла: ");
        Path filePath = Path.of(scanner.nextLine());

        System.out.print("Введите слово для поиска: ");
        String searchWord = scanner.nextLine();

        try {
            Files.lines(filePath)
                    .filter(line -> line.contains(searchWord))
                    .forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
