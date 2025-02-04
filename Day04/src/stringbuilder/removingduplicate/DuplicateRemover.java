package stringbuilder.removingduplicate;
import java.util.HashSet;

public class DuplicateRemover {
    public static String removeDuplicates(String input) {
        if (input == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();

        for (char c : input.toCharArray()) {
            if (!seen.contains(c)) {
                sb.append(c);
                seen.add(c);
            }
        }
        return sb.toString();
    }
}