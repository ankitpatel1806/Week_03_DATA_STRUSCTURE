package stringconcatenationperformance;

public class StringConcatenationPerformance {

    public static void main(String[] args) {
        int[] operationCounts = {1000, 10000, 1000000};

        for (int n : operationCounts) {
            System.out.println("Operation Count: " + n);

            // Measure time for String concatenation
            long startTime = System.nanoTime();
            StringConcatenation.concatenateWithString(n);
            long endTime = System.nanoTime();
            long stringTime = endTime - startTime;
            System.out.println("String Concatenation Time: " + stringTime / 1000000.0 + " ms");

            startTime = System.nanoTime();
            StringConcatenation.concatenateWithStringBuilder(n);
            endTime = System.nanoTime();
            long stringBuilderTime = endTime - startTime;
            System.out.println("StringBuilder Concatenation Time: " + stringBuilderTime / 1000000.0 + " ms");

            // Measure time for StringBuffer concatenation
            startTime = System.nanoTime();
            StringConcatenation.concatenateWithStringBuffer(n);
            endTime = System.nanoTime();
            long stringBufferTime = endTime - startTime;
            System.out.println("StringBuffer Concatenation Time: " + stringBufferTime / 1000000.0 + " ms");

            System.out.println();
        }
    }
}
