package stringbuilder.reverserstring;

public class StringReverser {

    // Method to reverse a given string using StringBuilder
    public static String reverseString(String input) {
        if (input == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(input);
        return sb.reverse().toString();
    }
}