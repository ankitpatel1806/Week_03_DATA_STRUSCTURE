package stackqueue.queueusingstacks;
import java.util.Stack;

public class QueueUsingStacks {
    private Stack<Integer> stack1 ;
    private Stack<Integer> stack2 ;
    public QueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    public void enqueue(int value) {
        stack1.push(value);
    }
    public int dequeue() {
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    public int peek() {
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
    public int size() {
        return stack1.size() + stack2.size();
    }
}
