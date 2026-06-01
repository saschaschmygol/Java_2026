package lr6;

import java.util.Arrays;

public class Task6 {
    public static long sum(int[] array) throws InterruptedException {
        if (array == null) {
            throw new IllegalArgumentException("Array must not be null");
        }

        if (array.length == 0) {
            return 0;
        }

        int threadCount = Runtime.getRuntime().availableProcessors();

        Thread[] threads = new Thread[threadCount];
        long[] localSums = new long[threadCount];

        for (int i = 0; i < threadCount; i++) {
            int threadIndex = i;
            int start = i * array.length / threadCount;
            int end = (i + 1) * array.length / threadCount;

            threads[i] = new Thread(() -> {
                long sum = 0;

                for (int j = start; j < end; j++) {
                    sum += array[j];
                }

                localSums[threadIndex] = sum;
            });

            threads[i].start();
        }

        long totalSum = 0;
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
            totalSum += localSums[i];
        }

        return totalSum;
    }

    public static void main(String[] args) throws InterruptedException {
        int[] numbers = {12, 45, 7, 89, 23, 56, 101, 4, 77, 39};

        System.out.println("Array: " + Arrays.toString(numbers));
        System.out.println("Sum: " + sum(numbers));
        System.out.println("Processor cores: " + Runtime.getRuntime().availableProcessors());
    }
}
