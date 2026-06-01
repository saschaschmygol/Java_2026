package lr6;

import java.util.Arrays;

public class Task5 {
    public static int findMax(int[] array) throws InterruptedException {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }

        int threadCount = Runtime.getRuntime().availableProcessors();

        Thread[] threads = new Thread[threadCount];
        int[] localMaxValues = new int[threadCount];
        Arrays.fill(localMaxValues, Integer.MIN_VALUE);

        for (int i = 0; i < threadCount; i++) {
            int threadIndex = i;
            int start = i * array.length / threadCount;
            int end = (i + 1) * array.length / threadCount;

            threads[i] = new Thread(() -> {
                if (start >= end) {
                    return;
                }

                int max = array[start];

                for (int j = start + 1; j < end; j++) {
                    if (array[j] > max) {
                        max = array[j];
                    }
                }

                localMaxValues[threadIndex] = max;
            });

            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        int max = localMaxValues[0];
        for (int i = 1; i < localMaxValues.length; i++) {
            if (localMaxValues[i] > max) {
                max = localMaxValues[i];
            }
        }

        return max;
    }

    public static void main(String[] args) throws InterruptedException {
        int[] numbers = {12, 45, 7, 89, 23, 56, 101, 4, 77, 39};

        System.out.println("Array: " + Arrays.toString(numbers));
        System.out.println("Max: " + findMax(numbers));
        System.out.println("Processor cores: " + Runtime.getRuntime().availableProcessors());
    }
}
