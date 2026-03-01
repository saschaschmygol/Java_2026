package lr1;

import java.util.Scanner;
public class Example7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите имя: ");
        String name = sc.nextLine();

        System.out.print("Введите возраст: ");
        int age = sc.nextInt();

        System.out.println("Ваше имя: " + name + ", ваш возраст: " + age);
    }
}
