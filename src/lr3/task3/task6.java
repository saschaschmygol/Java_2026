package lr3.task3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class task6 {

    public static int josephusArrayList(int n) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int index = 0;

        while (list.size() > 1) {
            index = (index + 1) % list.size(); // каждый второй
            list.remove(index);
        }

        return list.get(0);
    }

    public static int josephusLinkedList(int n) {
        List<Integer> list = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int index = 0;

        while (list.size() > 1) {
            index = (index + 1) % list.size();
            list.remove(index);
        }

        return list.get(0);
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Победитель (ArrayList): " + josephusArrayList(n));
        System.out.println("Победитель (LinkedList): " + josephusLinkedList(n));
    }
}