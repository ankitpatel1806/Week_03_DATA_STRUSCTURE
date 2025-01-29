package stackqueue.queueusingstacks;

public class QueueUsingStacksTest {
    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println("Size of Queue : " + queue.size());
        System.out.println("Peek : " + queue.peek());
        System.out.println("Dequeue Done : " + queue.dequeue());
        System.out.println("Dequeue Done : " + queue.dequeue());
        System.out.println("Dequeue Done : " + queue.dequeue());
        System.out.println("Is queue empty ? "+ queue.isEmpty());
        System.out.println("Dequeue Done : " + queue.dequeue());
        System.out.println("Is queue empty ? after last Dequeue : "+ queue.isEmpty());

    }
}
