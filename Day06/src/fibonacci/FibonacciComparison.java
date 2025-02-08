package fibonacci;

public class FibonacciComparison {
    public static void main(String[] args) {
        int[] testValues = {10, 30, 50};

        for (int n : testValues) {
            System.out.println("Computing Fibonacci for N = " + n);

            // Test Recursive Fibonacci
            System.out.println("Testing Recursive Fibonacci...");
            long startTime = System.currentTimeMillis();
            int recursiveResult = FibonacciRecursive.fibonacciRecursive(n);
            long endTime = System.currentTimeMillis();
            System.out.println("Recursive Result: " + recursiveResult + " (Time: " + (endTime - startTime) + " ms)");

            System.out.println("Testing Iterative Fibonacci...");
            startTime = System.currentTimeMillis();
            int iterativeResult = FibonacciIterative.fibonacciIterative(n);
            endTime = System.currentTimeMillis();
            System.out.println("Iterative Result: " + iterativeResult + " (Time: " + (endTime - startTime) + " ms)\n");
        }
    }
}
