package hashmaphashfunction.pairwithgivensum;
import java.util.HashMap;
import java.util.Map;

public class PairWithGivenSum {
    public boolean isPairWithGivenSum(int[] arr, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(sum - arr[i])) {
                return true;
            }
            map.put(arr[i], i);
        }
        return false;
    }
}
