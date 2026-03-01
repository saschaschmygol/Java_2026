package lr1;

import java.util.Scanner;
import java.time.Year;
public class Example10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите год рождения: ");
        int birthYear = sc.nextInt();

        int currentYear = Year.now().getValue();
        int age = currentYear - birthYear;

        System.out.println("Ваш возраст: " + age);
    }
}
