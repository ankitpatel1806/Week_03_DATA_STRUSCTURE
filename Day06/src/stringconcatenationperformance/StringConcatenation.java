package stringconcatenationperformance;

public class StringConcatenation {
    public static String concatenateWithString(int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += "a";
        }
        return result;
    }

    public static String concatenateWithStringBuilder(int n) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append("a");
        }
        return result.toString();
    }

    public static String concatenateWithStringBuffer(int n) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < n; i++) {
            result.append("a");
        }
        return result.toString();
    }
}