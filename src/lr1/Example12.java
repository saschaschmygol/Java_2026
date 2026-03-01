package lr1;

import java.util.Scanner;
import java.time.Year;
public class Example12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите возраст: ");
        int age = sc.nextInt();

        int currentYear = Year.now().getValue();
        int birthYear = currentYear - age;

        System.out.println("Ваш год рождения: " + birthYear);
    }
}
