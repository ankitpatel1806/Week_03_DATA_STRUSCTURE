package sortalgorithm.countingsort;

public class CountingSort {
    public void countingSort(int arr[]) {
        int n = arr.length;
        int output[] = new int[n];
        int count[] = new int[9];
        for (int i = 0; i < 9; i++) {
            count[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            count[arr[i] - 10]++;
        }
        for (int i = 1; i < 9; i++) {
            count[i] += count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i] - 10] - 1] = arr[i];
            count[arr[i] - 10]--;
        }
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

}
