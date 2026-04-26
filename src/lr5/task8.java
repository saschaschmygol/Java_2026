package lr5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class task8 {
    public static List<String> getStringsLongerThan(List<String> strings, int minLength) {
        return strings.stream()
                .filter(string -> string.length() > minLength)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("cat", "computer", "java", "program");
        System.out.println(getStringsLongerThan(strings, 4));
    }
}
