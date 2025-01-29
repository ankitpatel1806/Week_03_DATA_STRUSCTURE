package stackqueue.sortstackusingrecursion;
import java.util.Stack;
public class StackSorterTest {
    public static void main(String[] args) {
        StackSorter stackSorter = new StackSorter();
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(2);
        stack.push(4);
        stack.push(1);
        stack.push(3);
        System.out.println("Before sorting: " + stack);
        StackSorter.sort(stack);
        System.out.println("After sorting: " + stack);

    }
}
