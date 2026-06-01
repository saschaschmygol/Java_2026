package lr6;

public class Task4 {
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];

        for (int i = 0; i < threads.length; i++) {
            int threadNumber = i + 1;

            threads[i] = new Thread(() ->
                    System.out.println("Thread number: " + threadNumber));

            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }
}
