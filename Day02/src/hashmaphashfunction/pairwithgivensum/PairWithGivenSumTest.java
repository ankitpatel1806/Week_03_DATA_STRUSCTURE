package hashmaphashfunction.pairwithgivensum;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
public class PairWithGivenSumTest {
    public static void main(String[] args) {
        PairWithGivenSum pairWithGivenSum = new PairWithGivenSum();
        int[] arr = {1, 4, 45, 6, 10, -8};
        int sum = 16;
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Sum: " + sum);
        if (pairWithGivenSum.isPairWithGivenSum(arr, sum)) {
            System.out.println("Array has two elements with given sum");
        } else {
            System.out.println("Array doesn't have two elements with given sum");
        }
    }
}
