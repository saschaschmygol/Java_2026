package lr6;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Task1 {
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            long endTime = System.currentTimeMillis() + 10_000;

            while (System.currentTimeMillis() < endTime) {
                System.out.println(Thread.currentThread().getName() + ": "
                        + LocalTime.now().format(TIME_FORMATTER));

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        };

        Thread firstThread = new Thread(task, "FirstThread");
        Thread secondThread = new Thread(task, "SecondThread");

        firstThread.start();
        secondThread.start();

        firstThread.join();
        secondThread.join();
    }
}
