package lr2;

import java.util.Random;
import java.util.ArrayList;

public class task3 {
    public static void main(String[] args) {
        Random random = new Random();

        // Создаем массив на 15 элементов
        int[] arr = new int[15];

        // Заполняем массив случайными числами от -50 до 50
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(101) - 50;
        }

        // Выводим массив в консоль
        System.out.println("Массив:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        int min = arr[0];
        ArrayList<Integer> indexes = new ArrayList<>();
        indexes.add(0);

        // ищем минимальное значение и все его индексы
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                indexes.clear();
                indexes.add(i);
            } else if (arr[i] == min) {
                indexes.add(i);
            }
        }

        // результат
        System.out.println("Минимальный элемент: " + min);
        System.out.print("Индекс(ы): ");
        for (int index : indexes) {
            System.out.print(index + " ");
        }
    }
}
