package lr3.comp_collection;

import java.util.*;


public class task1 {
    private static final int N = 5_000_000;

    public static void main(String[] args) {

        System.out.println("=== ДОБАВЛЕНИЕ ===");
        testAddFirst();
        testAddLast();
        testAddMiddle();

        System.out.println("\n=== УДАЛЕНИЕ ===");
        testRemoveFirst();
        testRemoveLast();
        testRemoveMiddle();

        System.out.println("\n=== ДОСТУП ПО ИНДЕКСУ ===");
        testGet();
    }

    // ДОБАВЛЕНИЕ

    private static void testAddFirst() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        System.out.println("Добавление в начало:");

        System.out.println("ArrayList: " + measure(() -> {
            for (int i = 0; i < N; i++) arrayList.add(0, i);
        }));

        System.out.println("ArrayDeque: " + measure(() -> {
            for (int i = 0; i < N; i++) deque.addFirst(i);
        }));

        System.out.println("TreeSet: " + measure(() -> {
            for (int i = 0; i < N; i++) treeSet.add(i);
        }));
    }

    private static void testAddLast() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        System.out.println("\nДобавление в конец:");

        System.out.println("ArrayList: " + measure(() -> {
            for (int i = 0; i < N; i++) arrayList.add(i);
        }));

        System.out.println("ArrayDeque: " + measure(() -> {
            for (int i = 0; i < N; i++) deque.addLast(i);
        }));

        System.out.println("TreeSet: " + measure(() -> {
            for (int i = 0; i < N; i++) treeSet.add(i);
        }));
    }

    private static void testAddMiddle() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        fill(arrayList);
        fill(deque);
        fill(treeSet);

        System.out.println("\nДобавление в середину:");

        System.out.println("ArrayList: " + measure(() -> {
            arrayList.add(arrayList.size() / 2, 999);
        }));

        System.out.println("ArrayDeque: " + measure(() -> {
            // нет прямого доступа — эмулируем
            deque.add(999);
        }));

        System.out.println("TreeSet: " + measure(() -> {
            treeSet.add(999);
        }));
    }

    //УДАЛЕНИ

    private static void testRemoveFirst() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        fill(arrayList);
        fill(deque);
        fill(treeSet);

        System.out.println("\nУдаление в начале:");

        System.out.println("ArrayList: " + measure(() -> {
            arrayList.remove(0);
        }));

        System.out.println("ArrayDeque: " + measure(() -> {
            deque.removeFirst();
        }));

        System.out.println("TreeSet: " + measure(() -> {
            treeSet.pollFirst();
        }));
    }

    private static void testRemoveLast() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        fill(arrayList);
        fill(deque);
        fill(treeSet);

        System.out.println("\nУдаление в конце:");

        System.out.println("ArrayList: " + measure(() -> {
            arrayList.remove(arrayList.size() - 1);
        }));

        System.out.println("ArrayDeque: " + measure(() -> {
            deque.removeLast();
        }));

        System.out.println("TreeSet: " + measure(() -> {
            treeSet.pollLast();
        }));
    }

    private static void testRemoveMiddle() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        fill(arrayList);
        fill(deque);
        fill(treeSet);

        System.out.println("\nУдаление в середине:");

        System.out.println("ArrayList: " + measure(() -> {
            arrayList.remove(arrayList.size() / 2);
        }));

        System.out.println("ArrayDeque: " + measure(() -> {
            deque.remove(N / 2); // медленно (поиск)
        }));

        System.out.println("TreeSet: " + measure(() -> {
            treeSet.remove(N / 2);
        }));
    }

    // ДОСТУП

    private static void testGet() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        fill(arrayList);
        fill(deque);

        System.out.println("\nПолучение по индексу:");

        System.out.println("ArrayList: " + measure(() -> {
            arrayList.get(N / 2);
        }));

        System.out.println("ArrayDeque: " + measure(() -> {
            Iterator<Integer> it = deque.iterator();
            for (int i = 0; i < N / 2; i++) it.next();
            it.next();
        }));

        System.out.println("TreeSet: нет доступа по индексу");
    }


    private static long measure(Runnable task) {
        long start = System.nanoTime();
        task.run();
        long end = System.nanoTime();
        return end - start;
    }

    private static void fill(Collection<Integer> col) {
        for (int i = 0; i < N; i++) {
            col.add(i);
        }
    }
}
