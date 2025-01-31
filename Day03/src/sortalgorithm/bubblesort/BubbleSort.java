package sortalgorithm.bubblesort;
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int numberStudent = arr.length;
        int temp = 0;
        for (int i = 0; i < numberStudent; i++) {
            for (int j = 1; j < (numberStudent - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
