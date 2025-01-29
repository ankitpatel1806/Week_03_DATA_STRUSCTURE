package hashmaphashfunction.twosum;

import java.util.Arrays;

public class TwoSumTest {
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum.twoSum(nums, target);
        System.out.println("Indices of the two sum: " + Arrays.toString(result));
    }
}
