package stackqueue.sortstackusingrecursion;
import java.util.Stack;
public class StackSorter {
    public static void sort(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int top = stack.pop();
        sort(stack);
        insert(stack, top);
    }

    private static void insert(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
            return;
        }
        int top = stack.pop();
        insert(stack, element);
        stack.push(top);
    }

}
