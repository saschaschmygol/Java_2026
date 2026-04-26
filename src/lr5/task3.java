package lr5;

import java.util.Arrays;

public class task3 {
    public static int[] getCommonElements(int[] firstArray, int[] secondArray) {
        return Arrays.stream(firstArray)
                .filter(firstNumber -> Arrays.stream(secondArray)
                        .anyMatch(secondNumber -> secondNumber == firstNumber))
                .toArray();
    }

    public static void main(String[] args) {
        int[] firstArray = {1, 2, 3, 4, 5};
        int[] secondArray = {3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(getCommonElements(firstArray, secondArray)));
    }
}
