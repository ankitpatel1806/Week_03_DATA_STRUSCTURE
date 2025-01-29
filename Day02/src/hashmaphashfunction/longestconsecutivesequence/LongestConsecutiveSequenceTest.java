package hashmaphashfunction.longestconsecutivesequence;
import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequenceTest {
    public static void main(String[] args) {
        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println("Array: " + java.util.Arrays.toString(arr));
        System.out.println("Longest consecutive sequence: " + longestConsecutiveSequence.longestConsecutiveSequence(arr));
    }
}
