package lr5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class task4 {
    public static List<String> getStringsStartingWithUppercase(List<String> strings) {
        return strings.stream()
                .filter(string -> !string.isEmpty())
                .filter(string -> Character.isUpperCase(string.charAt(0)))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Java", "code", "Program", "test");
        System.out.println(getStringsStartingWithUppercase(strings));
    }
}
