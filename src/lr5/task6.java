package lr5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class task6 {
    public static List<String> getStringsContainingSubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(string -> string.contains(substring))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("table", "stable", "phone", "tablet");
        System.out.println(getStringsContainingSubstring(strings, "tab"));
    }
}
