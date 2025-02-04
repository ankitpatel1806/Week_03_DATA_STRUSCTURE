package linearsearch.firstnegetivenumber;

public class FirstNegetiveNumber {
    public static int firstNegetiveNumber(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return arr[i];
            }
        }
        return -1;
    }
}
