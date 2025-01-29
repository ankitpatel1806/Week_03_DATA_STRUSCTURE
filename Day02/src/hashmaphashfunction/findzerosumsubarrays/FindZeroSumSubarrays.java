package hashmaphashfunction.findzerosumsubarrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class FindZeroSumSubarrays {
    public List<int[]> findZeroSumSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();
        HashMap<Integer, List<Integer>> sumMap = new HashMap<>();
        int cumulativeSum = 0;
        sumMap.put(0, new ArrayList<>());
        for (int i = 0; i < arr.length; i++) {
            cumulativeSum += arr[i];
            if (sumMap.containsKey(cumulativeSum)) {
                // Get all indices where this sum occurred before
                List<Integer> indices = sumMap.get(cumulativeSum);
                for (int startIndex : indices) {
                    result.add(new int[]{startIndex + 1, i});
                }
            }
            sumMap.putIfAbsent(cumulativeSum, new ArrayList<>());
            sumMap.get(cumulativeSum).add(i);
        }

        return result;
    }
}
