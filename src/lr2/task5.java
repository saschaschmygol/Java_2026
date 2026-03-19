package lr2;

import java.util.Scanner;

public class task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "UTF-8");

        // Ввод исходного текста
        System.out.println("Введите текст для шифрования");
        String text = scanner.nextLine();

        // Ввод ключа шифрования
        System.out.println("Введите ключ");
        int key = scanner.nextInt();
        scanner.nextLine();

        // Шифрование текста
        String encrypted = transform(text, key);
        System.out.println("Текст после преобразования: " + encrypted);

        // Запрос на обратное преобразование
        while (true) {
            System.out.println("Выполнить обратное преобразование? (y/n)");
            String answer = scanner.nextLine();

            if (answer.equals("y")) {
                String decrypted = transform(encrypted, -key);
                System.out.println("Текст после обратного преобразования: " + decrypted);
                break;
            } else if (answer.equals("n")) {
                System.out.println("До свидания!");
                break;
            } else {
                System.out.println("Введите корректный ответ");
            }
        }
    }

    // Сдвиг символов по кодовой таблице
    static String transform(String text, int key) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            ch = (char) (ch + key);
            result.append(ch);
        }

        return result.toString();
    }
}
