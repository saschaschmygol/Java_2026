package lr5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class task7 {
    public static List<Integer> getDivisibleNumbers(List<Integer> numbers, int divisor) {
        return numbers.stream()
                .filter(number -> number % divisor == 0)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 4, 6, 8, 9, 12);
        System.out.println(getDivisibleNumbers(numbers, 3));
    }
}
