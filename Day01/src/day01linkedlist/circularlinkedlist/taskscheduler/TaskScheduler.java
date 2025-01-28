package day01linkedlist.circularlinkedlist.taskscheduler;

public class TaskScheduler {
    private Task head;  // The head of the circular list
    private Task tail;  // The tail of the circular list

    public TaskScheduler() {
        head = null;
        tail = null;
    }

    // Add a task at the beginning
    public void addTaskAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            tail = newTask;
            newTask.next = head;  // Circular link (tail points back to head)
        } else {
            newTask.next = head;
            head = newTask;
            tail.next = head;  // Maintain the circular link
        }
    }

    // Add a task at the end
    public void addTaskAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            tail = newTask;
            newTask.next = head;  // Circular link (tail points back to head)
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head;  // Maintain the circular link
        }
    }

    // Add a task at a specific position
    public void addTaskAtPosition(int position, int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (position == 1) {
            addTaskAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }

        Task current = head;
        int count = 1;

        // Traverse to the position
        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }

        if (current == null) {
            System.out.println("Position is out of bounds!");
            return;
        }

        newTask.next = current.next;
        current.next = newTask;
    }

    // Remove a task by Task ID
    public void removeTaskById(int taskId) {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        Task current = head;
        Task previous = null;

        do {
            if (current.taskId == taskId) {
                if (previous == null) {
                    // If it's the first task
                    head = current.next;
                    tail.next = head;  // Maintain the circular link
                } else {
                    previous.next = current.next;
                    if (current == tail) {
                        tail = previous;  // Update tail if last task is removed
                    }
                }
                System.out.println("Task with ID " + taskId + " removed.");
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);

        System.out.println("Task with ID " + taskId + " not found.");
    }

    // View current task and move to the next task
    public void viewCurrentTaskAndMove() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        Task current = head;
        System.out.println("Current Task: ID = " + current.taskId + ", Name = " + current.taskName +
                ", Priority = " + current.priority + ", Due Date = " + current.dueDate);

        head = head.next;  // Move to the next task
    }

    // Display all tasks in the list starting from the head node
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        Task current = head;
        do {
            System.out.println("Task ID: " + current.taskId + ", Name: " + current.taskName +
                    ", Priority: " + current.priority + ", Due Date: " + current.dueDate);
            current = current.next;
        } while (current != head);
    }

    // Search for a task by Priority
    public void searchTaskByPriority(int priority) {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        Task current = head;
        boolean found = false;
        do {
            if (current.priority == priority) {
                System.out.println("Found task with Priority " + priority + ": ID = " + current.taskId +
                        ", Name = " + current.taskName + ", Due Date = " + current.dueDate);
                found = true;
            }
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("No task found with Priority " + priority);
        }
    }

    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        // Add tasks
        scheduler.addTaskAtBeginning(1, "Task 1", 3, "2025-02-01");
        scheduler.addTaskAtEnd(2, "Task 2", 1, "2025-01-30");
        scheduler.addTaskAtEnd(3, "Task 3", 2, "2025-02-05");

        // Display all tasks
        System.out.println("All Tasks:");
        scheduler.displayAllTasks();

        // View current task and move to next task
        System.out.println("\nViewing and moving to the next task:");
        scheduler.viewCurrentTaskAndMove();

        // Display remaining tasks
        scheduler.displayAllTasks();

        // Add a task at a specific position
        scheduler.addTaskAtPosition(2, 4, "Task 4", 1, "2025-02-02");

        // Display all tasks
        System.out.println("\nAfter adding Task 4:");
        scheduler.displayAllTasks();

        // Remove a task by Task ID
        scheduler.removeTaskById(2);  // Remove task with ID 2

        // Display all tasks after removal
        System.out.println("\nAfter removing Task 2:");
        scheduler.displayAllTasks();

        // Search for a task by Priority
        scheduler.searchTaskByPriority(1);
    }
}
