package lr1;

import java.util.Scanner;
public class Example6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите фамилию: ");
        String lastName = sc.nextLine();

        System.out.print("Введите имя: ");
        String firstName = sc.nextLine();

        System.out.print("Введите отчество: ");
        String patronymic = sc.nextLine();

        System.out.println("Hello " + lastName + " " + firstName + " " + patronymic);
    }
}
