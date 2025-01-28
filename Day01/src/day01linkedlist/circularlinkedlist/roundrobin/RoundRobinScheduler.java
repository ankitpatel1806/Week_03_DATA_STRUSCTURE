package day01linkedlist.circularlinkedlist.roundrobin;

public class RoundRobinScheduler {
    private Process head;  // The head of the circular list
    private Process tail;  // The tail of the circular list
    private int timeQuantum;

    public RoundRobinScheduler(int timeQuantum) {
        head = null;
        tail = null;
        this.timeQuantum = timeQuantum;
    }

    // Add a new process at the end of the circular list
    public void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) {
            head = newProcess;
            tail = newProcess;
            newProcess.next = head;  // Circular link (tail points back to head)
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head;  // Maintain the circular link
        }
    }

    // Remove a process by Process ID after its execution
    public void removeProcessById(int processId) {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        Process current = head;
        Process previous = null;

        do {
            if (current.processId == processId) {
                if (previous == null) {
                    // If it's the first process
                    head = current.next;
                    tail.next = head;  // Maintain the circular link
                } else {
                    previous.next = current.next;
                    if (current == tail) {
                        tail = previous;  // Update tail if last process is removed
                    }
                }
                System.out.println("Process with ID " + processId + " removed after execution.");
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);

        System.out.println("Process with ID " + processId + " not found.");
    }

    // Simulate the round-robin scheduling of processes
    public void scheduleProcesses() {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        int processCount = 0;
        Process current = head;

        while (current != null) {
            if (current == head && current.next == head) break;  // Only one process left in the queue

            System.out.println("Executing process ID: " + current.processId);
            if (current.remainingBurstTime > timeQuantum) {
                current.remainingBurstTime -= timeQuantum;
                totalWaitingTime += current.remainingBurstTime; // Remaining time counts toward waiting time
            } else {
                totalWaitingTime += current.remainingBurstTime; // Process completes
                totalTurnaroundTime += current.burstTime;
                removeProcessById(current.processId);
            }

            // Move to the next process in the circular list
            current = current.next;

            // After each round, display the list of processes
            System.out.println("Processes in the queue:");
            displayProcesses();
        }

        // Calculate and display average waiting and turn-around times
        double averageWaitingTime = (double) totalWaitingTime / processCount;
        double averageTurnaroundTime = (double) totalTurnaroundTime / processCount;
        System.out.println("Average Waiting Time: " + averageWaitingTime);
        System.out.println("Average Turnaround Time: " + averageTurnaroundTime);
    }

    // Display the list of processes in the circular queue
    public void displayProcesses() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        Process current = head;
        do {
            System.out.println("Process ID: " + current.processId + ", Burst Time: " + current.burstTime +
                    ", Remaining Burst Time: " + current.remainingBurstTime + ", Priority: " + current.priority);
            current = current.next;
        } while (current != head);
    }

    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler(4); // Set time quantum to 4

        // Add processes to the scheduler
        scheduler.addProcess(1, 10, 3);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 8, 1);
        scheduler.addProcess(4, 6, 2);

        // Display initial processes
        System.out.println("Initial Processes in the Queue:");
        scheduler.displayProcesses();

        // Simulate the Round Robin scheduling
        scheduler.scheduleProcesses();
    }
}
