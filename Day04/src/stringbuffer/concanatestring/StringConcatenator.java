package stringbuffer.concanatestring;

public class StringConcatenator {
    public static String concatenateStrings(String[] strings) {
        if (strings == null || strings.length == 0) {
            return "";
        }

        StringBuffer sb = new StringBuffer();

        for (String str : strings) {
            sb.append(str + " " );
        }

        return sb.toString();
    }

}
