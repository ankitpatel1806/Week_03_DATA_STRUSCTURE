package sortalgorithm.insertionsort;

public class InsertionSort {
    public static void insertionSort(int[] employeeArr) {
        int emplyeeId = employeeArr.length;
        for (int i = 1; i < emplyeeId; i++) {
            int key = employeeArr[i];
            int j = i - 1;
            while (j >= 0 && employeeArr[j] > key) {
                employeeArr[j + 1] = employeeArr[j];
                j = j - 1;
            }
            employeeArr[j + 1] = key;
        }
    }
}
