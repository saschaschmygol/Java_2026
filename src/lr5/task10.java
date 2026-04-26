package lr5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class task10 {
    public static List<String> getOnlyLetterStrings(List<String> strings) {
        return strings.stream()
                .filter(string -> !string.isEmpty())
                .filter(string -> string.chars().allMatch(Character::isLetter))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Java", "Code123", "Program", "test!");
        System.out.println(getOnlyLetterStrings(strings));
    }
}
