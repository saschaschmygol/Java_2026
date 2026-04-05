package lr3.task3;

import java.util.HashMap;
import java.util.Map;

public class task5 {
    public static void main(String[] args) {

        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "apple");
        map.put(1, "banana");
        map.put(2, "kiwi");
        map.put(3, "strawberry");
        map.put(4, "pear");
        map.put(5, "pineapple");
        map.put(6, "melon");
        map.put(7, "watermelon");
        map.put(8, "plum");
        map.put(9, "cherry");

        // Найти строки, у которых ключ > 5
        System.out.println("Ключ > 5:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() > 5) {
                System.out.println(entry.getValue());
            }
        }

        //  Если ключ = 0, вывести строки через запятую
        System.out.print("\nКлюч = 0: ");
        boolean first = true;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() == 0) {
                if (!first) {
                    System.out.print(", ");
                }
                System.out.print(entry.getValue());
                first = false;
            }
        }

        // Перемножить все ключи, где длина строки > 5
        int product = 1;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().length() > 5) {
                product *= entry.getKey();
            }
        }

        System.out.println("\n\nПроизведение ключей (длина строки > 5): " + product);
    }
}