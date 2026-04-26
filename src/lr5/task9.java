package lr5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class task9 {
    public static List<Integer> getNumbersGreaterThan(List<Integer> numbers, int value) {
        return numbers.stream()
                .filter(number -> number > value)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 5, 8, 10, 3);
        System.out.println(getNumbersGreaterThan(numbers, 5));
    }
}
