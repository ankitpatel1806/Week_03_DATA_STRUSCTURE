package hashmaphashfunction.findzerosumsubarrays;

import java.util.Arrays;
import java.util.List;

public class FindZeroSumSubarraysTest {
    public static void main(String[] args) {
        FindZeroSumSubarrays finder = new FindZeroSumSubarrays();

        int[] arr = {6, -1, 3, -2, -3, 4, 2, -3};

        List<int[]> result = finder.findZeroSumSubarrays(arr);

        System.out.println("Zero Sum Subarrays:");
        for (int[] subarray : result) {
            System.out.println("Start: " + subarray[0] + ", End: " + subarray[1]);
            System.out.println("Subarray: " + Arrays.toString(Arrays.copyOfRange(arr, subarray[0], subarray[1] + 1)));
        }
    }
}
