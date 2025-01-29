package stackqueue.slidingwindowmaximum;
import java.util.Arrays;
public class SlidingWindowMaximumTest {
    public static void main(String[] args) {
        SlidingWindowMaximum swm = new SlidingWindowMaximum();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println("Input Array: " + Arrays.toString(nums));
        System.out.println("Sliding Window Maximum: " + Arrays.toString(swm.maxSlidingWindow(nums, k)));
    }
}
