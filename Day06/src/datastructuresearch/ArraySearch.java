package datastructuresearch;


public class ArraySearch {

    public static boolean search(Integer[] dataset, Integer value) {
        for (int i = 0; i < dataset.length; i++) {
            if (dataset[i].equals(value)) {
                return true;
            }
        }
        return false;
    }
}
