package hashmaphashfunction.longestconsecutivesequence;
import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
    public int longestConsecutiveSequence(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                continue;
            }
            int left = map.getOrDefault(arr[i] - 1, 0);
            int right = map.getOrDefault(arr[i] + 1, 0);
            int sum = left + right + 1;
            map.put(arr[i], sum);
            max = Math.max(max, sum);
            map.put(arr[i] - left, sum);
            map.put(arr[i] + right, sum);
        }
        return max;
    }
}
