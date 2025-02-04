package linearsearch.findspecificword;

public class FindSpecificWord {
    public static String findSpecificWord(String[] arr, String word) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(word)) {
                return word;
            }
        }
        return "Word not found";
    }
}
