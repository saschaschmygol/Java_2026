package lr3.task3;

import java.util.Scanner;

public class task8 {

    static class Node {
        int value;
        Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    static class LinkedList {
        Node head;

        //ЦИКЛЫ

        // ввод с головы
        void createHead(int n, Scanner scanner) {
            for (int i = 0; i < n; i++) {
                int value = scanner.nextInt();
                head = new Node(value, head);
            }
        }

        // ввод с хвоста
        void createTail(int n, Scanner scanner) {
            if (head == null) {
                head = new Node(scanner.nextInt(), null);
                n--;
            }
            Node tail = head;

            while (tail.next != null) {
                tail = tail.next;
            }

            for (int i = 0; i < n; i++) {
                tail.next = new Node(scanner.nextInt(), null);
                tail = tail.next;
            }
        }

        // вывод
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node temp = head;

            while (temp != null) {
                sb.append(temp.value).append(" ");
                temp = temp.next;
            }
            return sb.toString();
        }

        // добавить в начало
        void addFirst(int value) {
            head = new Node(value, head);
        }

        // добавить в конец
        void addLast(int value) {
            if (head == null) {
                head = new Node(value, null);
                return;
            }

            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = new Node(value, null);
        }

        // вставка по индексу
        void insert(int index, int value) {
            if (index == 0) {
                addFirst(value);
                return;
            }

            Node temp = head;
            for (int i = 0; i < index - 1 && temp != null; i++) {
                temp = temp.next;
            }

            if (temp != null) {
                temp.next = new Node(value, temp.next);
            }
        }

        // удалить первый
        void removeFirst() {
            if (head != null) {
                head = head.next;
            }
        }

        // удалить последний
        void removeLast() {
            if (head == null || head.next == null) {
                head = null;
                return;
            }

            Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }

            temp.next = null;
        }

        // удалить по индексу
        void remove(int index) {
            if (index == 0) {
                removeFirst();
                return;
            }

            Node temp = head;
            for (int i = 0; i < index - 1 && temp.next != null; i++) {
                temp = temp.next;
            }

            if (temp.next != null) {
                temp.next = temp.next.next;
            }
        }

        // РЕКУРСИЯ

        // ввод с головы
        void createHeadRec(int n, Scanner scanner) {
            if (n == 0) return;
            int value = scanner.nextInt();
            head = new Node(value, head);
            createHeadRec(n - 1, scanner);
        }

        // ввод с хвоста
        Node createTailRecHelper(int n, Scanner scanner) {
            if (n == 0) return null;
            int value = scanner.nextInt();
            return new Node(value, createTailRecHelper(n - 1, scanner));
        }

        void createTailRec(int n, Scanner scanner) {
            head = createTailRecHelper(n, scanner);
        }

        // вывод
        String toStringRec(Node node) {
            if (node == null) return "";
            return node.value + " " + toStringRec(node.next);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList list = new LinkedList();

        System.out.print("Введите количество элементов: ");
        int n = scanner.nextInt();

        System.out.println("Введите элементы:");
        list.createTail(n, scanner);

        System.out.println("Список: " + list.toString());

        list.addFirst(100);
        list.addLast(200);
        System.out.println("После добавлений: " + list.toString());

        list.insert(2, 999);
        System.out.println("После вставки: " + list.toString());

        list.removeFirst();
        list.removeLast();
        list.remove(1);
        System.out.println("После удалений: " + list.toString());

        System.out.println("Рекурсивный вывод: " + list.toStringRec(list.head));

        scanner.close();
    }
}